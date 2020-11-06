package com.lingyun.service.impl;

import com.lingyun.entity.TbGoodsDesc;
import com.lingyun.dao.TbGoodsDescDao;
import com.lingyun.service.TbGoodsDescService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbGoodsDesc)表服务实现类
 *
 * @author makejava
 * @since 2020-11-01 15:45:28
 */
@DubboService
public class TbGoodsDescServiceImpl implements TbGoodsDescService {
    @Resource
    private TbGoodsDescDao tbGoodsDescDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public TbGoodsDesc queryById(Long goodsId) {
        return this.tbGoodsDescDao.queryById(goodsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbGoodsDesc> queryAllByLimit(int offset, int limit) {
        return this.tbGoodsDescDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
    @Override
    public TbGoodsDesc insert(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDescDao.insert(tbGoodsDesc);
        return tbGoodsDesc;
    }

    /**
     * 修改数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
    @Override
    public TbGoodsDesc update(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDescDao.update(tbGoodsDesc);
        return this.queryById(tbGoodsDesc.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long goodsId) {
        return this.tbGoodsDescDao.deleteById(goodsId) > 0;
    }
}