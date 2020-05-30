package com.keji.pojo;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: sale
 * @description: 客户表
 * @author: lxh
 * @create: 2019-09-07 16:25
 **/

/*
Field                 Type          Collation        Null    Key     Default              Extra   Privileges                       Comment
--------------------  ------------  ---------------  ------  ------  -------------------  ------  -------------------------------  --------------
customer_id           int(10)       (NULL)           NO      PRI     (NULL)                       select,insert,update,references  客户编号
customer_name         varchar(255)  utf8_general_ci  NO              (NULL)                       select,insert,update,references  客户姓名
customer_sex          varchar(255)  utf8_general_ci  YES             (NULL)                       select,insert,update,references  性别
customer_telephone    varchar(20)   utf8_general_ci  YES             (NULL)                       select,insert,update,references  客户电话
customer_date         date          (NULL)           YES             (NULL)                       select,insert,update,references  出生日期
customer_creatDate    timestamp     (NULL)           NO              CURRENT_TIMESTAMP            select,insert,update,references  创建日期
customer_modifieDate  timestamp     (NULL)           NO              0000-00-00 00:00:00          select,insert,update,references  修改日期
customer_modifier     varchar(255)  utf8_general_ci  YES             (NULL)                       select,insert,update,references  修改人
customer_state        varchar(255)  utf8_general_ci  YES             0                            select,insert,update,references  状态

 */
public class Customer {
    private int customerId;//客户编号
    private String customerName;//客户姓名
    private String customerSex;//客户性别
    private String customerTelephone;//客户电话
    private Date customerDate;//出生日期
    private Date customerCreatDate;//创建日期
    private Date customerModifieDate;//修改日期
    private int customerModifier;//修改人
    private int customerState;//状态

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
    }

    public Date getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(Date customerDate) {
        this.customerDate = customerDate;
    }

    public Date getCustomerCreatDate() {
        return customerCreatDate;
    }

    public void setCustomerCreatDate(Date customerCreatDate) {
        this.customerCreatDate = customerCreatDate;
    }

    public Date getCustomerModifieDate() {
        return customerModifieDate;
    }

    public void setCustomerModifieDate(Date customerModifieDate) {
        this.customerModifieDate = customerModifieDate;
    }

    public int getCustomerModifier() {
        return customerModifier;
    }

    public void setCustomerModifier(int customerModifier) {
        this.customerModifier = customerModifier;
    }

    public int getCustomerState() {
        return customerState;
    }

    public void setCustomerState(int customerState) {
        this.customerState = customerState;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSex='" + customerSex + '\'' +
                ", customerTelephone='" + customerTelephone + '\'' +
                ", customerDate=" + customerDate +
                ", customerCreatDate=" + customerCreatDate +
                ", customerModifieDate=" + customerModifieDate +
                ", customerModifier=" + customerModifier +
                ", customerState=" + customerState +
                '}';
    }
}
