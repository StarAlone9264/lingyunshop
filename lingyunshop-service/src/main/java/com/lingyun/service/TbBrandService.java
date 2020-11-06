package com.lingyun.service;

import com.lingyun.entity.TbBrand;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;

import java.util.List;

/**
 * (TbBrand)表服务接口
 *
 * @author makejava
 * @since 2020-10-21 00:51:16
 */
public interface TbBrandService {
    /**
     * 分页查询
     * @param pageRequest pageRequest
     * @return PageResult
     */
    PageResult queryPage(PageRequest pageRequest);

    /**
     * 删除
     * @param ids ids
     * @return String
     */
    String dycDelByIds(List<Long> ids);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbBrand queryById(Long id);
    /**
     * 查询
     * @param tbBrand tbBrand
     * @return List
     */
    List<TbBrand> queryAll(TbBrand tbBrand);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbBrand> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 返回数据
     */
    String insert(TbBrand tbBrand);

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 返回数据
     */
    String update(TbBrand tbBrand);

}