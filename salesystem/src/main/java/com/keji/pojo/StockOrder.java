package com.keji.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TianXiangbo
 * @date 2019/9/7 0007 17:26
 * Content:进货单
 */
public class StockOrder {

    private Integer stoId;    //进货单号
    private Integer stoSupId;    //供货商编号（引用（t_supplier表）sup_id）
    private BigDecimal stoTotal;    //货物总价
    private Date stoDate;    //进货日期
    private String stoRemark;    //备注
    private Date stoCreate;    //创建日期
    private Date stoUpdate;    //修改日期
    private int stoIsDelete;    //是否已删除，取值为0和1默认为0.
    private int stoModifier;    //修改人（引用（t_user表）user_id）

    public Integer getStoId() {
        return stoId;
    }

    public void setStoId(Integer stoId) {
        this.stoId = stoId;
    }

    public Integer getStoSupId() {
        return stoSupId;
    }

    public void setStoSupId(Integer stoSupId) {
        this.stoSupId = stoSupId;
    }

    public BigDecimal getStoTotal() {
        return stoTotal;
    }

    public void setStoTotal(BigDecimal stoTotal) {
        this.stoTotal = stoTotal;
    }

    public Date getStoDate() {
        return stoDate;
    }

    public void setStoDate(Date stoDate) {
        this.stoDate = stoDate;
    }

    public String getStoRemark() {
        return stoRemark;
    }

    public void setStoRemark(String stoRemark) {
        this.stoRemark = stoRemark;
    }

    public Date getStoCreate() {
        return stoCreate;
    }

    public void setStoCreate(Date stoCreate) {
        this.stoCreate = stoCreate;
    }

    public Date getStoUpdate() {
        return stoUpdate;
    }

    public void setStoUpdate(Date stoUpdate) {
        this.stoUpdate = stoUpdate;
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
        return "StockOrder{" +
                "stoId=" + stoId +
                ", stoSupId=" + stoSupId +
                ", stoTotal=" + stoTotal +
                ", stoDate=" + stoDate +
                ", stoRemark='" + stoRemark + '\'' +
                ", stoCreate=" + stoCreate +
                ", stoUpdate=" + stoUpdate +
                ", stoIsDelete=" + stoIsDelete +
                ", stoModifier=" + stoModifier +
                '}';
    }
}
