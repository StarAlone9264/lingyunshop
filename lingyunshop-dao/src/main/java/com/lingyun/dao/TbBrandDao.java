package com.lingyun.dao;

import com.lingyun.entity.TbBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbBrand)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-21 00:51:16
 */
@Mapper
public interface TbBrandDao {

    /**
     * 分页查询
     * @return list 集合
     */
    List<TbBrand> queryPage();

    /**
     * 动态删除
     * @param ids id
     * @return int
     */
    int dycDelByIds(List<Long> ids);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbBrand queryById(Long id);

    /**
     * 通过name查询单条数据
     * @param name 品牌名称
     * @return 实例对象
     */
    TbBrand queryByName(String name);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbBrand> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbBrand 实例对象
     * @return 对象列表
     */
    List<TbBrand> queryAll(TbBrand tbBrand);

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 影响行数
     */
    int insert(TbBrand tbBrand);

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 影响行数
     */
    int update(TbBrand tbBrand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}