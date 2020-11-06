package com.lingyun.service;

import com.lingyun.entity.TbSpecification;
import com.lingyun.entity.vo.TbSpecificationOptionVo;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;

import java.util.List;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/22 0:27
 */
public interface TbSpecificationService {
    /**
     * 分页查全部
     * @param pageRequest pageRequest
     * @return pageResult
     */
    PageResult queryAll(PageRequest pageRequest);

    /**
     * 查全部
     * @return List
     */
    List<TbSpecification> list();
    /**
     * 动态查询
     * @param tbSpecification tbSpecification
     * @return 实体对象
     */
    TbSpecification dycQuery(TbSpecification tbSpecification);
    /**
     * 添加
     * @param tbSpecificationOptionVo tbSpecificationOptionVo
     * @return String
     */
    String insert(TbSpecificationOptionVo tbSpecificationOptionVo);
    /**
     * 修改
     * @param tbSpecificationOptionVo tbSpecificationOptionVo
     * @return String
     */
    String update(TbSpecificationOptionVo tbSpecificationOptionVo);
    /**
     * 循环删除
     * @param ids tbSpecification
     * @return String
     */
    String dycDelByIds(List<Long> ids);

    List<TbSpecificationOptionVo> batchQuery(List<Long> ids);
}
