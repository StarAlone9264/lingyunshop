package com.lingyun.dao;

import com.lingyun.entity.TbSpecificationOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/21 23:19
 */
@Mapper
public interface TbSpecificationOptionDao {

    /**
     * 依据规格id查询
     * @param specId specId
     * @return List
     */
    List<TbSpecificationOption> queryById(Integer specId);

    /**
     * 动态查询
     * @param tbSpecificationOption tbSpecificationOption
     * @return TbSpecificationOption
     */
    TbSpecificationOption dncQuery(TbSpecificationOption tbSpecificationOption);
    /**
     * 动态删除
     * @param tbSpecificationOption 实体
     * @return int
     */
    int dncDel(TbSpecificationOption tbSpecificationOption);

    /**
     * 添加
     * @param tbSpecificationOption tbSpecificationOption
     * @return int
     */
    int insert(TbSpecificationOption tbSpecificationOption);

    /**
     * 修改
     * @param tbSpecificationOption tbSpecificationOption
     * @return int
     */
    int update(TbSpecificationOption tbSpecificationOption);
}
