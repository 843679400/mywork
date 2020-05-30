package com.keji.pojo;


import lombok.Data;

/**
 * cpq
 * 商品销售额同环比
 * Created by Administrator on 2019/9/9.
 */
@Data
public class ProductStatistics {

    private int productid;//商品id
    private String productName;//商品名称
    private int orderamount;//订单明细表 数量
    //private int orderAggregateAmount;//订单表 总金额
    private int year;//年份
    private int month;//月份

    public ProductStatistics() {

    }

    public ProductStatistics(int productid, String productName, int orderamount, int year, int month) {
        this.productid = productid;
        this.productName = productName;
        this.orderamount = orderamount;
        this.year = year;
        this.month = month;
    }

}
