package com.lingyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lingyun.dao.TbSpecificationDao;
import com.lingyun.dao.TbSpecificationOptionDao;
import com.lingyun.entity.TbSpecification;
import com.lingyun.entity.TbSpecificationOption;
import com.lingyun.entity.TbTypeTemplate;
import com.lingyun.entity.vo.TbSpecificationOptionVo;
import com.lingyun.service.TbSpecificationService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;
import com.lingyun.util.PageUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/22 0:28
 */
@DubboService
public class TbSpecificationServiceImpl implements TbSpecificationService {

    @Resource
    private TbSpecificationDao tbSpecificationDao;
    @Resource
    private TbSpecificationOptionDao tbSpecificationOptionDao;

    @Override
    public PageResult queryAll(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public List<TbSpecification> list() {
        return tbSpecificationDao.queryAll();
    }

    @Override
    public TbSpecification dycQuery(TbSpecification tbSpecification) {
        return tbSpecificationDao.dycQuery(tbSpecification);
    }

    @Override
    public String insert(TbSpecificationOptionVo tbSpecificationOptionVo) {
        TbSpecification tbSpecification = tbSpecificationOptionVo.getTbSpecification();
        // 判断该规格 是否存在
        TbSpecification query = tbSpecificationDao.dycQuery(new TbSpecification().setSpecName(tbSpecification.getSpecName()));
        if (query != null) return "existed";
        // 判断规格添加是否成功
        if (tbSpecificationDao.insert(tbSpecification) <= 0) return "error";
        List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionVo.getTbSpecificationOptions();
        // 判断规格选项是否为空
        if (tbSpecificationOptions.isEmpty() || (tbSpecificationOptions.size() > 0 && (tbSpecificationOptions.stream().anyMatch(option -> (option.getOptionName().equals("") || option.getOptionName() == null)))))
            return "success";
        // 判断该规格下的 规格选项是否重复
        for (TbSpecificationOption tbSpecificationOption : tbSpecificationOptions) {
            TbSpecificationOption option = tbSpecificationOptionDao.dncQuery(new TbSpecificationOption().setOptionName(tbSpecificationOption.getOptionName()).setSpecId(tbSpecification.getId()));
            // 判断规格选项是否重复
            if (option != null) return option.getOptionName() + "已存在！";
        }
        // 添加规格选项
        for (TbSpecificationOption option : tbSpecificationOptions) {
            tbSpecificationOptionDao.insert(new TbSpecificationOption().setOptionName(option.getOptionName()).setSpecId(tbSpecification.getId()).setOrders(option.getOrders()));
        }
        return "success";
    }

    @Override
    public String update(TbSpecificationOptionVo tbSpecificationOptionVo) {
        // 判断该规格是否存在
        if (tbSpecificationDao.dycQuery(new TbSpecification().setId(tbSpecificationOptionVo.getTbSpecification().getId())) == null)
            return "null";
        // 修改主表
        if (tbSpecificationDao.update(tbSpecificationOptionVo.getTbSpecification()) <= 0) return "error";
        // 判断tbSpecificationOptionVo是否存在规格选项,如果存在规格选项则修改，如果不存在则删除原有规格选项
        List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionVo.getTbSpecificationOptions();
        if (tbSpecificationOptions.isEmpty()) {
            List<TbSpecificationOption> options = tbSpecificationOptionDao.queryById(Math.toIntExact(tbSpecificationOptionVo.getTbSpecification().getId()));
            if (options != null || !options.isEmpty()) {
                tbSpecificationOptionDao.dncDel(new TbSpecificationOption().setSpecId(tbSpecificationOptionVo.getTbSpecification().getId()));
            }
            return "success";
        } else if (tbSpecificationOptions.size() > 0 && (tbSpecificationOptions.stream().anyMatch(option -> option.getOptionName() == null))) {
            List<TbSpecificationOption> options = tbSpecificationOptionDao.queryById(Math.toIntExact(tbSpecificationOptionVo.getTbSpecification().getId()));
            if (options != null || !options.isEmpty()) {
                tbSpecificationOptionDao.dncDel(new TbSpecificationOption().setSpecId(tbSpecificationOptionVo.getTbSpecification().getId()));
            }
            return "success";
        }
        // 修改/添加规格选项
        for (TbSpecificationOption tbSpecificationOption : tbSpecificationOptions) {
            try {
                if (tbSpecificationOption.getId() == 0) {
                    System.out.println("添加");
                    tbSpecificationOptionDao.insert(new TbSpecificationOption().setOptionName(tbSpecificationOption.getOptionName()).setSpecId(tbSpecificationOptionVo.getTbSpecification().getId()).setOrders(tbSpecificationOption.getOrders()));
                } else {
                    System.out.println("修改");
                    int i = tbSpecificationOptionDao.update(new TbSpecificationOption().setId(tbSpecificationOption.getId()).setOptionName(tbSpecificationOption.getOptionName()).setSpecId(tbSpecificationOptionVo.getTbSpecification().getId()).setOrders(tbSpecificationOption.getOrders()));
                    System.out.println(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return "success";
    }

    @Override
    public String dycDelByIds(List<Long> ids) {
        // 删除规格选项
        for (Long id : ids) {
            TbSpecification tbSpecification = tbSpecificationDao.dycQuery(new TbSpecification().setId(id));
            System.out.println(tbSpecification);
            if (tbSpecification == null) return "error";
            List<TbSpecificationOption> list = tbSpecificationOptionDao.queryById(Math.toIntExact(tbSpecification.getId()));
            if (list.isEmpty()) break;
            if (tbSpecificationOptionDao.dncDel(new TbSpecificationOption().setSpecId(tbSpecification.getId())) <= 0)
                return "error";
        }
        if (tbSpecificationDao.dycDelByIds(ids) > 0) return "success";
        return "error";
    }


    @Override
    public List<TbSpecificationOptionVo> batchQuery(List<Long> ids) {
        List<TbSpecificationOptionVo> list = new ArrayList<>();
        for (Long id : ids) {
            TbSpecificationOptionVo optionVo = new TbSpecificationOptionVo();
            TbSpecification tbSpecification = tbSpecificationDao.dycQuery(new TbSpecification().setId(id));
            List<TbSpecificationOption> options = tbSpecificationOptionDao.queryById(Math.toIntExact(id));
            optionVo.setTbSpecification(tbSpecification).setTbSpecificationOptions(options);
            list.add(optionVo);
        }
        return list;
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest pageRequest
     * @return PageInfo
     */
    private PageInfo<TbSpecificationOptionVo> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TbSpecificationOptionVo> optionVoList = new ArrayList<>();
        List<TbSpecification> tbSpecificationList = tbSpecificationDao.queryAll();
        tbSpecificationList.forEach(tbSpecification -> {
            List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionDao.queryById(Math.toIntExact(tbSpecification.getId()));
            optionVoList.add(new TbSpecificationOptionVo().setTbSpecification(tbSpecification).setTbSpecificationOptions(tbSpecificationOptions));
        });
        return new PageInfo<TbSpecificationOptionVo>(optionVoList);
    }
}
