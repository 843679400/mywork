package com.keji.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TianXiangbo
 * @date 2019/9/7 16:15
 * Content:库存表
 */
public class Repository {

    private Integer repId;    //库存编号
    private Integer repSupId;    //供应商编号
    private Integer repProductId;    //商品编号
    private BigDecimal repPurch;    //进价
    private Integer repQuantity;    //库存数量
    private Date repPurchDate;      //进货日期
    private String repRemark;    //备注
    private Date repCreate;    //创建日期
    private Date repUpdate;    //修改日期
    private int repIsDelete;    //是否已删除
    private int repModifier;    //修改人

    private String supName;    //供应商名称
    private String productName;    //商品名称
    private String productStandard;    //商品规格
    private String productAddress;    // 商品产地
    private Integer productWarning;    //库存预警

    public Repository() {
    }

    public Repository(Integer repId, Integer repSupId, Integer repProductId, BigDecimal repPurch, Integer repQuantity, Date repPurchDate, String repRemark, int repModifier) {
        this.repId = repId;
        this.repSupId = repSupId;
        this.repProductId = repProductId;
        this.repPurch = repPurch;
        this.repQuantity = repQuantity;
        this.repPurchDate = repPurchDate;
        this.repRemark = repRemark;
        this.repModifier = repModifier;
    }

    public Repository(Integer repId, BigDecimal repPurch, Integer repQuantity, String supName, String productName, String productStandard, String productAddress) {
        this.repId = repId;
        this.repPurch = repPurch;
        this.repQuantity = repQuantity;
        this.supName = supName;
        this.productName = productName;
        this.productStandard = productStandard;
        this.productAddress = productAddress;
    }

    public Date getRepPurchDate() {
        return repPurchDate;
    }

    public void setRepPurchDate(Date repPurchDate) {
        this.repPurchDate = repPurchDate;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductStandard() {
        return productStandard;
    }

    public void setProductStandard(String productStandard) {
        this.productStandard = productStandard;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public Integer getProductWarning() {
        return productWarning;
    }

    public void setProductWarning(Integer productWarning) {
        this.productWarning = productWarning;
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public Integer getRepSupId() {
        return repSupId;
    }

    public void setRepSupId(Integer repSupId) {
        this.repSupId = repSupId;
    }

    public Integer getRepProductId() {
        return repProductId;
    }

    public void setRepProductId(Integer repProductId) {
        this.repProductId = repProductId;
    }

    public BigDecimal getRepPurch() {
        return repPurch;
    }

    public void setRepPurch(BigDecimal repPurch) {
        this.repPurch = repPurch;
    }

    public Integer getRepQuantity() {
        return repQuantity;
    }

    public void setRepQuantity(Integer repQuantity) {
        this.repQuantity = repQuantity;
    }

    public String getRepRemark() {
        return repRemark;
    }

    public void setRepRemark(String repRemark) {
        this.repRemark = repRemark;
    }

    public Date getRepCreate() {
        return repCreate;
    }

    public void setRepCreate(Date repCreate) {
        this.repCreate = repCreate;
    }

    public Date getRepUpdate() {
        return repUpdate;
    }

    public void setRepUpdate(Date repUpdate) {
        this.repUpdate = repUpdate;
    }

    public int getRepIsDelete() {
        return repIsDelete;
    }

    public void setRepIsDelete(int repIsDelete) {
        this.repIsDelete = repIsDelete;
    }

    public int getRepModifier() {
        return repModifier;
    }

    public void setRepModifier(int repModifier) {
        this.repModifier = repModifier;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "repId=" + repId +
                ", repSupId=" + repSupId +
                ", repProductId=" + repProductId +
                ", repPurch=" + repPurch +
                ", repQuantity=" + repQuantity +
                ", repPurchDate=" + repPurchDate +
                ", repRemark='" + repRemark + '\'' +
                ", repCreate=" + repCreate +
                ", repUpdate=" + repUpdate +
                ", repIsDelete=" + repIsDelete +
                ", repModifier=" + repModifier +
                ", supName='" + supName + '\'' +
                ", productName='" + productName + '\'' +
                ", productStandard='" + productStandard + '\'' +
                ", productAddress='" + productAddress + '\'' +
                ", productWarning=" + productWarning +
                '}';
    }
}
