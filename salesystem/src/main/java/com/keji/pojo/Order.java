package com.keji.pojo;

/**
 * @author 李天笑
 * @date 2019/9/7 17:03
 * 订单表
 */

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private String id;
    //订单编号
    private String orderId;
    //客户编号（引用（t_customer表）cus_id）
    private Integer orderCusId;
    //总金额
    private BigDecimal orderAggregateAmount;
    //员工编号（引用（t_emp表）emp_id）
    private Integer orderEmpId;
    //创建日期
    private Date orderCreateDate;
    //修改日期
    private Date orderUpdateDate;
    //（状态）是否已删除，取值为0和1默认为0。
    private String orderState;
    //是否已交押金，取值为0和1默认为0
    private int orderDeposit;
    //是否已交全款，取值为0和1默认为0 当交完全款以后表示订单完成
    private int orderFullPayment;
    //备注
    private String orderRemark;
    //押金
    private String orderCashPledge;
    //客户信息
    private Consumer consumer = new Consumer();
    //订单详情
    private OrderDetail orderDetail = new OrderDetail();
}
