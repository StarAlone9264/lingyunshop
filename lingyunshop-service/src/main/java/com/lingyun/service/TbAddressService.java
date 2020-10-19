package com.lingyun.service;

import com.lingyun.entity.TbAddress;

import java.util.List;

/**
 * (TbAddress)表服务接口
 *
 * @author makejava
 * @since 2020-10-19 00:15:26
 */
public interface TbAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbAddress queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbAddress> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    TbAddress insert(TbAddress tbAddress);

    /**
     * 修改数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    TbAddress update(TbAddress tbAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}