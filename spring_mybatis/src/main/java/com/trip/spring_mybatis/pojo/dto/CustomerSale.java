package com.trip.spring_mybatis.pojo.dto;

import lombok.Data;

import java.util.Date;

/**
 * 会员营销活动信息表
 */
@Data
public class CustomerSale {
    private Integer id;
    /**
     * 活动名称
     */
    private String saleName;
    private String startDate;
    private String endDate;
    /**
     * 活动时间支持星期数
     */
    private String saleWeek;
    /**
     * 活动类型,枚举 customer_sale_discount_type
     */
    private String saleType;
    /**
     * 活动归属（商户类型1:平台、2:景区）
     */
    private Integer merchantType;
    /**
     * 联商户ID(智景通平台:-1)
     */
    private Integer merchantId;
    /**
     * 活动说明
     */
    private String introduction;
    /**
     * 是否与优惠券互斥
     */
    private Integer couponAlternative;
    /**
     * 是否删除：0否，1是（逻辑删除）
     */
    private Integer isDelete;
    /**
     * 状态 0：无效 1：有效
     */
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
