package com.keji.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TianXiangbo
 * @date 2019/9/7 17:21
 * Content:退货明细表
 */
public class RePurchaseDetail {

    private int repurId;    //退货明细单号
    private int rePurId;    //退货明细单号
    private int rePurProductId;    //商品编号（引用（t_product表）pro_id）
    private int rePurStoId;    //进货单号（引用（t_stock表）sto_id）
    private BigDecimal rePurPrice;    //货物单价
    private int rePurAmount;    //货物数量
    private Date rePurDate;    //进货日期
    private String rePurRemark;    //备注
    private Date rePurCreate;    //创建日期
    private Date rePurUpdate;    //修改日期
    private int rePurIsDelete;    //是否已删除，取值为0和1默认为0
    private int rePurModifier;    //修改人（引用（t_user表）user_id）

    public int getRepurId() {
        return repurId;
    }

    public void setRepurId(int repurId) {
        this.repurId = repurId;
    }

    public int getRePurId() {
        return rePurId;
    }

    public void setRePurId(int rePurId) {
        this.rePurId = rePurId;
    }

    public int getRePurProductId() {
        return rePurProductId;
    }

    public void setRePurProductId(int rePurProductId) {
        this.rePurProductId = rePurProductId;
    }

    public int getRePurStoId() {
        return rePurStoId;
    }

    public void setRePurStoId(int rePurStoId) {
        this.rePurStoId = rePurStoId;
    }

    public BigDecimal getRePurPrice() {
        return rePurPrice;
    }

    public void setRePurPrice(BigDecimal rePurPrice) {
        this.rePurPrice = rePurPrice;
    }

    public int getRePurAmount() {
        return rePurAmount;
    }

    public void setRePurAmount(int rePurAmount) {
        this.rePurAmount = rePurAmount;
    }

    public Date getRePurDate() {
        return rePurDate;
    }

    public void setRePurDate(Date rePurDate) {
        this.rePurDate = rePurDate;
    }

    public String getRePurRemark() {
        return rePurRemark;
    }

    public void setRePurRemark(String rePurRemark) {
        this.rePurRemark = rePurRemark;
    }

    public Date getRePurCreate() {
        return rePurCreate;
    }

    public void setRePurCreate(Date rePurCreate) {
        this.rePurCreate = rePurCreate;
    }

    public Date getRePurUpdate() {
        return rePurUpdate;
    }

    public void setRePurUpdate(Date rePurUpdate) {
        this.rePurUpdate = rePurUpdate;
    }

    public int getRePurIsDelete() {
        return rePurIsDelete;
    }

    public void setRePurIsDelete(int rePurIsDelete) {
        this.rePurIsDelete = rePurIsDelete;
    }

    public int getRePurModifier() {
        return rePurModifier;
    }

    public void setRePurModifier(int rePurModifier) {
        this.rePurModifier = rePurModifier;
    }

    @Override
    public String toString() {
        return "RePurchaseDetail{" +
                "repurId=" + repurId +
                ", rePurId=" + rePurId +
                ", rePurProductId=" + rePurProductId +
                ", rePurStoId=" + rePurStoId +
                ", rePurPrice=" + rePurPrice +
                ", rePurAmount=" + rePurAmount +
                ", rePurDate=" + rePurDate +
                ", rePurRemark='" + rePurRemark + '\'' +
                ", rePurCreate=" + rePurCreate +
                ", rePurUpdate=" + rePurUpdate +
                ", rePurIsDelete=" + rePurIsDelete +
                ", rePurModifier=" + rePurModifier +
                '}';
    }
}
