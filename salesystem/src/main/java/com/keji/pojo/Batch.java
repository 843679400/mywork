package com.keji.pojo;

import java.math.BigDecimal;

/**
 * @author 李天笑
 * @date 2019/9/9 9:25
 * 批量上传
 */
public class Batch {
    //商品 id
    private String productId;
    //商品价格
    private BigDecimal productPrice;
    //购买量
    private int num;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "productId='" + productId + '\'' +
                ", productPrice=" + productPrice +
                ", num=" + num +
                '}';
    }
}
