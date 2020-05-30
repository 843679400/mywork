package com.keji.pojo;

import lombok.Data;

/**
 * 购物车实体类
 */

@Data
public class ShopCart {
    private int id;//主键
    private String number;//用户账号
    private String productId;//商品编号
    private int productSum;//商品数量
    private Product product = new Product();
}
