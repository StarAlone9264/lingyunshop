package com.lingyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbSeller)实体类
 *
 * @author makejava
 * @since 2020-10-28 17:06:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbSeller implements Serializable {
    private static final long serialVersionUID = -21076507095261838L;
    /**
    * 用户ID
    */
    private String sellerId;
    /**
    * 公司名
    */
    private String name;
    /**
    * 店铺名称
    */
    private String nickName;
    /**
    * 密码
    */
    private String password;
    /**
    * EMAIL
    */
    private String email;
    /**
    * 公司手机
    */
    private String mobile;
    /**
    * 公司电话
    */
    private String telephone;
    /**
    * 状态
    */
    private String status;
    /**
    * 详细地址
    */
    private String addressDetail;
    /**
    * 联系人姓名
    */
    private String linkmanName;
    /**
    * 联系人QQ
    */
    private String linkmanQq;
    /**
    * 联系人电话
    */
    private String linkmanMobile;
    /**
    * 联系人EMAIL
    */
    private String linkmanEmail;
    /**
    * 营业执照号
    */
    private String licenseNumber;
    /**
    * 税务登记证号
    */
    private String taxNumber;
    /**
    * 组织机构代码
    */
    private String orgNumber;
    /**
    * 公司地址
    */
    private Long address;
    /**
    * 公司LOGO图
    */
    private String logoPic;
    /**
    * 简介
    */
    private String brief;
    /**
    * 创建日期
    */
    private Date createTime;
    /**
    * 法定代表人
    */
    private String legalPerson;
    /**
    * 法定代表人身份证
    */
    private String legalPersonCardId;
    /**
    * 开户行账号名称
    */
    private String bankUser;
    /**
    * 开户行
    */
    private String bankName;
}