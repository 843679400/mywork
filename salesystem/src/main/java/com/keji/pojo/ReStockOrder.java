package com.keji.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TianXiangbo
 * @date 2019/9/7 18:07
 * Content:退货单
 */
public class ReStockOrder {

    private Integer reStoId;    //退货单号
    private Integer reStoSupId;    //供货商编号（引用（t_supplier表）sup_id）
    private BigDecimal reStoTotal;    //货物总价
    private Date reStoDate;    //退货日期
    private String reStoRemark;    //备注
    private Date reStoCreate;    //创建日期
    private Date reStoUpdate;    //修改日期
    private int stoIsDelete;    //是否已删除，取值为0和1默认为0.
    private int stoModifier;    //修改人（引用（t_user表）user_id）

    public Integer getReStoId() {
        return reStoId;
    }

    public void setReStoId(Integer reStoId) {
        this.reStoId = reStoId;
    }

    public Integer getReStoSupId() {
        return reStoSupId;
    }

    public void setReStoSupId(Integer reStoSupId) {
        this.reStoSupId = reStoSupId;
    }

    public BigDecimal getReStoTotal() {
        return reStoTotal;
    }

    public void setReStoTotal(BigDecimal reStoTotal) {
        this.reStoTotal = reStoTotal;
    }

    public Date getReStoDate() {
        return reStoDate;
    }

    public void setReStoDate(Date reStoDate) {
        this.reStoDate = reStoDate;
    }

    public String getReStoRemark() {
        return reStoRemark;
    }

    public void setReStoRemark(String reStoRemark) {
        this.reStoRemark = reStoRemark;
    }

    public Date getReStoCreate() {
        return reStoCreate;
    }

    public void setReStoCreate(Date reStoCreate) {
        this.reStoCreate = reStoCreate;
    }

    public Date getReStoUpdate() {
        return reStoUpdate;
    }

    public void setReStoUpdate(Date reStoUpdate) {
        this.reStoUpdate = reStoUpdate;
    }

    public int getStoIsDelete() {
        return stoIsDelete;
    }

    public void setStoIsDelete(int stoIsDelete) {
        this.stoIsDelete = stoIsDelete;
    }

    public int getStoModifier() {
        return stoModifier;
    }

    public void setStoModifier(int stoModifier) {
        this.stoModifier = stoModifier;
    }

    @Override
    public String toString() {
        return "ReStockOrder{" +
                "reStoId=" + reStoId +
                ", reStoSupId=" + reStoSupId +
                ", reStoTotal=" + reStoTotal +
                ", reStoDate=" + reStoDate +
                ", reStoRemark='" + reStoRemark + '\'' +
                ", reStoCreate=" + reStoCreate +
                ", reStoUpdate=" + reStoUpdate +
                ", stoIsDelete=" + stoIsDelete +
                ", stoModifier=" + stoModifier +
                '}';
    }
}
