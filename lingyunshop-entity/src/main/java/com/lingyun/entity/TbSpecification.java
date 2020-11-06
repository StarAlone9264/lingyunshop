package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/21 23:11
 * 规格实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbSpecification implements Serializable {
    private long id;
    private String specName;

    public TbSpecification(String specName) {
        this.specName = specName;
    }
}
