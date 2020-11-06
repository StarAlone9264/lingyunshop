package com.lingyun.dao;

import com.lingyun.entity.TbSeller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (TbSeller)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-28 17:07:35
 */
@Mapper
public interface TbSellerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    TbSeller queryById(String sellerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbSeller> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param map 实例对象
     * @return 对象列表
     */
    List<TbSeller> queryAll(Map map);

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 影响行数
     */
    int insert(TbSeller tbSeller);

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 影响行数
     */
    int update(TbSeller tbSeller);

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 影响行数
     */
    int deleteById(String sellerId);

    /**
     * 动态查询
     * @param tbSeller 对象
     * @return 对象
     */
    TbSeller query(TbSeller tbSeller);
}