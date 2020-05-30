package com.keji.pojo;

/**
 * @author 成雨齐
 * @date 2019/9/7 17:26
 */

import lombok.Data;

import java.math.BigDecimal;

/**
 * 工资单实体类
 */
@Data
public class SalaryBills {
   private int empNumber; //员工编号
   private String positionName; //职务名称
    private BigDecimal basicSalary; //底薪
    private BigDecimal insurance ; //保险
    private BigDecimal  performance; //绩效
    private BigDecimal bonus; //奖金
    private int  late ; // 矿工天数
    private int overTime; //加班 小时
    private BigDecimal salary; //工资
    private String data; //日期
    private String yiyiText; // 异议信息

}
