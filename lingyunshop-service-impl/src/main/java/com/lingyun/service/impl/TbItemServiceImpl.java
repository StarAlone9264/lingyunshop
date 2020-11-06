package com.lingyun.service.impl;

import com.lingyun.entity.TbItem;
import com.lingyun.dao.TbItemDao;
import com.lingyun.service.TbItemService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(TbItem)表服务实现类
 *
 * @author makejava
 * @since 2020-11-01 15:50:24
 */
@DubboService
public class TbItemServiceImpl implements TbItemService {
    @Resource
    private TbItemDao tbItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbItem queryById(Long id) {
        return this.tbItemDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbItem> queryAllByLimit(int offset, int limit) {
        return this.tbItemDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<TbItem> queryAll(TbItem tbItem) {
        return tbItemDao.queryAll(tbItem);
    }

    /**
     * 新增数据
     *
     * @param tbItem 实例对象
     * @return 实例对象
     */
    @Override
    public TbItem insert(TbItem tbItem) {
        this.tbItemDao.insert(tbItem);
        return tbItem;
    }

    /**
     * 修改数据
     *
     * @param tbItem 实例对象
     * @return 实例对象
     */
    @Override
    public TbItem update(TbItem tbItem) {
        this.tbItemDao.update(tbItem);
        return this.queryById(tbItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbItemDao.deleteById(id) > 0;
    }
}