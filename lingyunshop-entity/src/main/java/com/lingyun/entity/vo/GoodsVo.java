package com.lingyun.entity.vo;

import com.lingyun.entity.TbGoods;
import com.lingyun.entity.TbGoodsDesc;
import com.lingyun.entity.TbItem;
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
 * @date 2020/11/1 14:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class GoodsVo implements Serializable {
    private TbGoods tbGoods;
    private TbGoodsDesc tbGoodsDesc;
    private List<TbItem> itemList;
}
