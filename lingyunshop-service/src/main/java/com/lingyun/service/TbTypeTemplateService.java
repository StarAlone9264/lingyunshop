package com.lingyun.service;

import com.lingyun.entity.TbTypeTemplate;
import com.lingyun.entity.vo.TbSpecificationOptionVo;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;

import java.util.List;

/**
 * (TbTypeTemplate)表服务接口
 *
 * @author makejava
 * @since 2020-10-25 12:23:05
 */
public interface TbTypeTemplateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbTypeTemplate queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param pageRequest pageRequest
     * @return 对象列表
     */
    PageResult queryAllByLimit(PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbTypeTemplate 实例对象
     * @return String
     */
    String insert(TbTypeTemplate tbTypeTemplate);

    /**
     * 修改数据
     *
     * @param tbTypeTemplate 实例对象
     * @return String
     */
    String update(TbTypeTemplate tbTypeTemplate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量删除
     * @param ids ids
     * @return int
     */
    String dycDelByIds(List<Long> ids);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbTypeTemplate 实例对象
     * @return 对象列表
     */
    List<TbTypeTemplate> queryAll(TbTypeTemplate tbTypeTemplate);

}