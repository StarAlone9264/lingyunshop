package com.lingyun.dao;

import com.lingyun.entity.TbSpecification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/21 23:18
 */
@Mapper
public interface TbSpecificationDao {
    /**
     * 查全部
     * @return list
     */
    List<TbSpecification> queryAll();
    /**
     * 动态查询
     * @param tbSpecification tbSpecification
     * @return 实体对象
     */
    TbSpecification dycQuery(TbSpecification tbSpecification);
    /**
     * 添加
     * @param tbSpecification tbSpecification
     * @return int
     */
    int insert(TbSpecification tbSpecification);
    /**
     * 修改
     * @param tbSpecification tbSpecification
     * @return int
     */
    int update(TbSpecification tbSpecification);
    /**
     * 循环删除
     * @param ids tbSpecification
     * @return int
     */
    int dycDelByIds(List<Long> ids);
}
