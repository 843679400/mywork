package com.keji.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/9/8.
 */
@Data
public class DeptStatistics implements Serializable{
    private String empName;//员工名称
    private String deptName;//销售部门
    private int orderaggregateAmount;//每个人的总金额
    private int oederYear;//年份
    private int orderMonth;//月份

    public DeptStatistics() {
    }

    public DeptStatistics(String empName, String deptName, int orderaggregateAmount, int oederYear, int orderMonth) {
        this.empName = empName;
        this.deptName = deptName;
        this.orderaggregateAmount = orderaggregateAmount;
        this.oederYear = oederYear;
        this.orderMonth = orderMonth;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getOrderaggregateAmount() {
        return orderaggregateAmount;
    }

    public void setOrderaggregateAmount(int orderaggregateAmount) {
        this.orderaggregateAmount = orderaggregateAmount;
    }

    public int getOederYear() {
        return oederYear;
    }

    public void setOederYear(int oederYear) {
        this.oederYear = oederYear;
    }

    public int getOrderMonth() {
        return orderMonth;
    }

    public void setOrderMonth(int orderMonth) {
        this.orderMonth = orderMonth;
    }

    @Override
    public String toString() {
        return "DeptStatistics{" +
                "empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", orderaggregateAmount=" + orderaggregateAmount +
                ", oederYear=" + oederYear +
                ", orderMonth=" + orderMonth +
                '}';
    }
}
