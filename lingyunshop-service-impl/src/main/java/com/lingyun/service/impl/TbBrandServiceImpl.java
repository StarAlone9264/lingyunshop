package com.lingyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lingyun.dao.TbBrandDao;
import com.lingyun.entity.TbBrand;
import com.lingyun.service.TbBrandService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;
import com.lingyun.util.PageUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbBrand)表服务实现类
 *
 * @author makejava
 * @since 2020-10-21 00:51:17
 */
@DubboService
public class TbBrandServiceImpl implements TbBrandService {
    @Resource
    private TbBrandDao tbBrandDao;

    @Override
    public PageResult queryPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public String dycDelByIds(List<Long> ids) {
        if (this.tbBrandDao.dycDelByIds(ids) > 0){
            return "success";
        }
        return "error";
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest pageRequest
     * @return PageInfo
     */
    private PageInfo<TbBrand> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TbBrand> list = tbBrandDao.queryPage();
        return new PageInfo<TbBrand>(list);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbBrand queryById(Long id) {
        return this.tbBrandDao.queryById(id);
    }

    @Override
    public List<TbBrand> queryAll(TbBrand tbBrand) {
        return tbBrandDao.queryAll(tbBrand);
    }

    /**
     * 查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbBrand> queryAllByLimit(int offset, int limit) {
        return this.tbBrandDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(TbBrand tbBrand) {
        if (tbBrandDao.queryByName(tbBrand.getName()) != null) return "existed";
        if (tbBrandDao.insert(tbBrand) > 0) return "success";
        return "error";
    }

    /**
     * 修改数据
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    @Override
    public String update(TbBrand tbBrand) {
        if (tbBrandDao.queryById(tbBrand.getId()) == null) return "null";
        if (tbBrandDao.update(tbBrand.setFirstChar(tbBrand.getFirstChar().toUpperCase())) > 0) return "success";
        return "error";
    }

}