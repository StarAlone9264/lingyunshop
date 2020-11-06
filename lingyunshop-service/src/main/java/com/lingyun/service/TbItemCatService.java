package com.lingyun.service;

import com.lingyun.entity.TbItemCat;
import com.lingyun.util.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 商品类目(TbItemCat)表服务接口
 *
 * @author makejava
 * @since 2020-10-31 14:14:24
 */
public interface TbItemCatService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbItemCat queryById(Long id);


    /**
     * 分页查询
     * @param map 对象
     * @return PageResult
     */
    PageResult queryPage(Map map);

    /**
     * 根据id查询
     *
     * @param id 查询条数
     * @return 对象列表
     */
    List<TbItemCat> query(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbItemCat> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    String insert(TbItemCat tbItemCat);

    /**
     * 修改数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    String update(TbItemCat tbItemCat);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}