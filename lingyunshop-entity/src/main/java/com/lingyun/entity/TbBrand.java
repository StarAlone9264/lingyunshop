package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbBrand)实体类
 *
 * @author makejava
 * @since 2020-10-21 00:50:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbBrand implements Serializable {
    private static final long serialVersionUID = 545711483971537814L;
    
    private Long id;
    /**
    * 品牌名称
    */
    private String name;
    /**
    * 品牌首字母
    */
    private String firstChar;

    public TbBrand(String name, String firstChar) {
        this.name = name;
        this.firstChar = firstChar;
    }
}