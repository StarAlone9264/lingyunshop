package com.lingyun.service;

import com.lingyun.entity.TbSeller;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;

import java.util.List;
import java.util.Map;

/**
 * (TbSeller)表服务接口
 *
 * @author makejava
 * @since 2020-10-28 17:09:02
 */
public interface TbSellerService {

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    TbSeller queryById(String sellerId);

    /**
     * 分页查询
     * @param map 状态,其他
     * @return PageResult
     */
    PageResult queryPage(Map map);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param status 状态
     * @return 对象列表
     */
    List<TbSeller> queryAll(String status);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbSeller> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    String insert(TbSeller tbSeller);

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    String update(TbSeller tbSeller);

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 是否成功
     */
    boolean deleteById(String sellerId);

    /**
     * 动态查询
     * @param tbSeller 对象
     * @return 对象
     */
    TbSeller query(TbSeller tbSeller);

}