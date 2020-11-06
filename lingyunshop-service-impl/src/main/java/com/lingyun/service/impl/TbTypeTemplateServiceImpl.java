package com.lingyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lingyun.entity.TbSpecification;
import com.lingyun.entity.TbSpecificationOption;
import com.lingyun.entity.TbTypeTemplate;
import com.lingyun.dao.TbTypeTemplateDao;
import com.lingyun.entity.vo.TbSpecificationOptionVo;
import com.lingyun.service.TbTypeTemplateService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;
import com.lingyun.util.PageUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TbTypeTemplate)表服务实现类
 *
 * @author makejava
 * @since 2020-10-25 12:23:21
 */
@DubboService
public class TbTypeTemplateServiceImpl implements TbTypeTemplateService {
    @Resource
    private TbTypeTemplateDao tbTypeTemplateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbTypeTemplate queryById(Long id) {
        return this.tbTypeTemplateDao.queryById(id);
    }


    /**
     * 查询多条数据
     *
     * @param pageRequest pageRequest
     * @return 对象列表
     */
    @Override
    public PageResult queryAllByLimit(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 新增数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(TbTypeTemplate tbTypeTemplate) {
        List<TbTypeTemplate> tbTypeTemplates = tbTypeTemplateDao.queryAll(new TbTypeTemplate().setName(tbTypeTemplate.getName()));
        System.out.println(tbTypeTemplates);
        if (!tbTypeTemplates.isEmpty()) return tbTypeTemplate.getName() + "existed";
        if (tbTypeTemplateDao.insert(tbTypeTemplate) > 0) return "success";
        return "error";
    }

    /**
     * 修改数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public String update(TbTypeTemplate tbTypeTemplate) {
        if (tbTypeTemplateDao.queryAll(new TbTypeTemplate().setId(tbTypeTemplate.getId())).isEmpty()) return "error";
        if (this.tbTypeTemplateDao.update(tbTypeTemplate) > 0) return "success";
        return "error";
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }


    @Override
    public String dycDelByIds(List<Long> ids) {
        if (this.tbTypeTemplateDao.dycDelByIds(ids) > 0) {
            return "success";
        }
        return "error";
    }

    @Override
    public List<TbTypeTemplate> queryAll(TbTypeTemplate tbTypeTemplate) {
        return tbTypeTemplateDao.queryAll(tbTypeTemplate);
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest pageRequest
     * @return PageInfo
     */
    private PageInfo<TbTypeTemplate> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TbTypeTemplate> tbTypeTemplates = tbTypeTemplateDao.queryAll(null);
        return new PageInfo<TbTypeTemplate>(tbTypeTemplates);
    }
}