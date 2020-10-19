package com.lingyun.dao;

import com.lingyun.entity.TbAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbAddress)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-19 00:12:38
 */
@Mapper
public interface TbAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbAddress queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbAddress> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbAddress 实例对象
     * @return 对象列表
     */
    List<TbAddress> queryAll(TbAddress tbAddress);

    /**
     * 新增数据
     *
     * @param tbAddress 实例对象
     * @return 影响行数
     */
    int insert(TbAddress tbAddress);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbAddress> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbAddress> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbAddress> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TbAddress> entities);

    /**
     * 修改数据
     *
     * @param tbAddress 实例对象
     * @return 影响行数
     */
    int update(TbAddress tbAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}