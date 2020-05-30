package com.keji.pojo;

/**
 * @author 李天笑
 * @date 2019/9/7 19:27
 * 还款类
 */

import java.math.BigDecimal;
import java.util.Date;


public class Gathering  {
    private Integer gathId;
    private Date gathDate;
    private BigDecimal gathMoney;
    private String gathOrderId;
    private String gathRemark;
    private Date gathCreateDate;
    private Date gathUpdateDate;
    private int gathState;
    private int gathModifier;

    public Integer getGathId() {
        return gathId;
    }

    public void setGathId(Integer gathId) {
        this.gathId = gathId;
    }

    public Date getGathDate() {
        return gathDate;
    }

    public void setGathDate(Date gathDate) {
        this.gathDate = gathDate;
    }

    public BigDecimal getGathMoney() {
        return gathMoney;
    }

    public void setGathMoney(BigDecimal gathMoney) {
        this.gathMoney = gathMoney;
    }

    public String getGathOrderId() {
        return gathOrderId;
    }

    public void setGathOrderId(String gathOrderId) {
        this.gathOrderId = gathOrderId;
    }

    public String getGathRemark() {
        return gathRemark;
    }

    public void setGathRemark(String gathRemark) {
        this.gathRemark = gathRemark;
    }

    public Date getGathCreateDate() {
        return gathCreateDate;
    }

    public void setGathCreateDate(Date gathCreateDate) {
        this.gathCreateDate = gathCreateDate;
    }

    public Date getGathUpdateDate() {
        return gathUpdateDate;
    }

    public void setGathUpdateDate(Date gathUpdateDate) {
        this.gathUpdateDate = gathUpdateDate;
    }

    public int getGathState() {
        return gathState;
    }

    public void setGathState(int gathState) {
        this.gathState = gathState;
    }

    public int getGathModifier() {
        return gathModifier;
    }

    public void setGathModifier(int gathModifier) {
        this.gathModifier = gathModifier;
    }

    @Override
    public String toString() {
        return "Gathering{" +
                "gathId=" + gathId +
                ", gathDate=" + gathDate +
                ", gathMoney=" + gathMoney +
                ", gathOrderId='" + gathOrderId + '\'' +
                ", gathRemark='" + gathRemark + '\'' +
                ", gathCreateDate=" + gathCreateDate +
                ", gathUpdateDate=" + gathUpdateDate +
                ", gathState=" + gathState +
                ", gathModifier=" + gathModifier +
                '}';
    }
}
