package com.lingyun.service;

import com.lingyun.entity.TbGoodsDesc;
import java.util.List;

/**
 * (TbGoodsDesc)表服务接口
 *
 * @author makejava
 * @since 2020-11-01 15:45:11
 */
public interface TbGoodsDescService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    TbGoodsDesc queryById(Long goodsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbGoodsDesc> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
    TbGoodsDesc insert(TbGoodsDesc tbGoodsDesc);

    /**
     * 修改数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
    TbGoodsDesc update(TbGoodsDesc tbGoodsDesc);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(Long goodsId);

}