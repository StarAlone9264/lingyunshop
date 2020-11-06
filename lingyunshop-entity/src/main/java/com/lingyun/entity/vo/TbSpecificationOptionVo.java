package com.lingyun.entity.vo;

import com.lingyun.entity.TbSpecification;
import com.lingyun.entity.TbSpecificationOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/21 23:15
 * 规格选项vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbSpecificationOptionVo implements Serializable {
    private TbSpecification tbSpecification;
    private List<TbSpecificationOption> tbSpecificationOptions;
}
