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
 * @date 2020/10/21 23:13
 * 规格选项实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbSpecificationOption implements Serializable {
    private long id;
    private String optionName;
    private long specId;
    private Integer orders;
}
