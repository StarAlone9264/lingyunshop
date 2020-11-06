package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbTypeTemplate)实体类
 *
 * @author makejava
 * @since 2020-10-25 12:21:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbTypeTemplate implements Serializable {
    private static final long serialVersionUID = 764328414110272147L;
    
    private Long id;
    /**
    * 模板名称
    */
    private String name;
    /**
    * 关联规格
    */
    private String specIds;
    /**
    * 关联品牌
    */
    private String brandIds;
    /**
    * 自定义属性
    */
    private String customAttributeItems;

}