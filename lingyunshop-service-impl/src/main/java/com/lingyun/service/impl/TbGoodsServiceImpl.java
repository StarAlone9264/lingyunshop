package com.lingyun.service.impl;

import com.lingyun.entity.TbGoods;
import com.lingyun.dao.TbGoodsDao;
import com.lingyun.service.TbGoodsService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbGoods)表服务实现类
 *
 * @author makejava
 * @since 2020-11-01 15:43:52
 */
@DubboService
public class TbGoodsServiceImpl implements TbGoodsService {
    @Resource
    private TbGoodsDao tbGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbGoods queryById(Long id) {
        return this.tbGoodsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbGoods> queryAllByLimit(int offset, int limit) {
        return this.tbGoodsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    @Override
    public TbGoods insert(TbGoods tbGoods) {
        this.tbGoodsDao.insert(tbGoods);
        return tbGoods;
    }

    /**
     * 修改数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    @Override
    public TbGoods update(TbGoods tbGoods) {
        this.tbGoodsDao.update(tbGoods);
        return this.queryById(tbGoods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbGoodsDao.deleteById(id) > 0;
    }
}