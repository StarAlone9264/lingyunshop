package com.lingyun.service;

import com.lingyun.entity.TbGoods;
import java.util.List;

/**
 * (TbGoods)表服务接口
 *
 * @author makejava
 * @since 2020-11-01 15:43:42
 */
public interface TbGoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbGoods queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbGoods> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    TbGoods insert(TbGoods tbGoods);

    /**
     * 修改数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    TbGoods update(TbGoods tbGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}