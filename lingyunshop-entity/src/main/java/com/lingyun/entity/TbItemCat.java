package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 商品类目(TbItemCat)实体类
 *
 * @author makejava
 * @since 2020-10-31 14:12:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbItemCat implements Serializable {
    private static final long serialVersionUID = 621294987882683470L;
    /**
    * 类目ID
    */
    private Long id;
    /**
    * 父类目ID=0时，代表的是一级的类目
    */
    private Long parentId;
    /**
    * 类目名称
    */
    private String name;
    /**
    * 类型id
    */
    private Long typeId;

}