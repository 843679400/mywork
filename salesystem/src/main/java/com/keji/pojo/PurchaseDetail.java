package com.keji.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TianXiangbo
 * @date 2019/9/7 17:13
 * Content:进货明细表
 */
public class PurchaseDetail {
    private int purId;    //进货明细单号
    private int purProductId;    //商品编号（引用（t_product表）pro_id）
    private int purStoId;    //进货单号（引用（t_stock表）sto_id）
    private BigDecimal purPrice;    //货物单价
    private int purAmount;    //货物数量
    private Date purDate;    //进货日期
    private String purRemark;    //备注
    private Date purCreate;    //创建日期
    private Date purUpdate;    //修改日期
    private int purIsDelete;    //是否已删除，取值为0和1默认为0
    private int purModifier;    //修改人（引用（t_user表）user_id）

    public int getPurId() {
        return purId;
    }

    public void setPurId(int purId) {
        this.purId = purId;
    }

    public int getPurProductId() {
        return purProductId;
    }

    public void setPurProductId(int purProductId) {
        this.purProductId = purProductId;
    }

    public int getPurStoId() {
        return purStoId;
    }

    public void setPurStoId(int purStoId) {
        this.purStoId = purStoId;
    }

    public BigDecimal getPurPrice() {
        return purPrice;
    }

    public void setPurPrice(BigDecimal purPrice) {
        this.purPrice = purPrice;
    }

    public int getPurAmount() {
        return purAmount;
    }

    public void setPurAmount(int purAmount) {
        this.purAmount = purAmount;
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public String getPurRemark() {
        return purRemark;
    }

    public void setPurRemark(String purRemark) {
        this.purRemark = purRemark;
    }

    public Date getPurCreate() {
        return purCreate;
    }

    public void setPurCreate(Date purCreate) {
        this.purCreate = purCreate;
    }

    public Date getPurUpdate() {
        return purUpdate;
    }

    public void setPurUpdate(Date purUpdate) {
        this.purUpdate = purUpdate;
    }

    public int getPurIsDelete() {
        return purIsDelete;
    }

    public void setPurIsDelete(int purIsDelete) {
        this.purIsDelete = purIsDelete;
    }

    public int getPurModifier() {
        return purModifier;
    }

    public void setPurModifier(int purModifier) {
        this.purModifier = purModifier;
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" +
                "purId=" + purId +
                ", purProductId=" + purProductId +
                ", purStoId=" + purStoId +
                ", purPrice=" + purPrice +
                ", purAmount=" + purAmount +
                ", purDate=" + purDate +
                ", purRemark='" + purRemark + '\'' +
                ", purCreate=" + purCreate +
                ", purUpdate=" + purUpdate +
                ", purIsDelete=" + purIsDelete +
                ", purModifier=" + purModifier +
                '}';
    }
}
