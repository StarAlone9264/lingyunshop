package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbGoods)实体类
 *
 * @author makejava
 * @since 2020-11-01 14:53:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbGoods implements Serializable {
    private static final long serialVersionUID = 460874252810460817L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 商家ID
    */
    private String sellerId;
    /**
    * SPU名
    */
    private String goodsName;
    /**
    * 默认SKU
    */
    private Long defaultItemId;
    /**
    * 状态
    */
    private String auditStatus;
    /**
    * 是否上架
    */
    private String isMarketable;
    /**
    * 品牌
    */
    private Long brandId;
    /**
    * 副标题
    */
    private String caption;
    /**
    * 一级类目
    */
    private Long category1Id;
    /**
    * 二级类目
    */
    private Long category2Id;
    /**
    * 三级类目
    */
    private Long category3Id;
    /**
    * 小图
    */
    private String smallPic;
    /**
    * 商城价
    */
    private Double price;
    /**
    * 分类模板ID
    */
    private Long typeTemplateId;
    /**
    * 是否启用规格
    */
    private String isEnableSpec;
    /**
    * 是否删除
    */
    private String isDelete;

}