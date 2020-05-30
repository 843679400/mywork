package com.keji.pojo;

/**
 * @author 李天笑
 * @date 2019/9/7 19:09
 * 订单详情
 */


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDetail {
    private String id;
    private String orderId;
    private String orderGooId;
    private BigDecimal orderPrice;
    private String orderPiscounts;//商品名称
    private int orderAmount;
    private String orderRemark;
    private Date orderCreateDate;
    private String orderUpdateDate;
    private String orderModifier;
}
