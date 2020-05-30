package com.keji.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: sale_System
 * @description: 员工表
 * @author: 李东升
 * @create: 2019-09-07 17:00
 *
 **/
@Data
public class Emp {
    private int empId; //
    private int empNumber;  //员工编号
    private String empPassword; //员工密码
    private String empName; //员工姓名
    private Integer empGender;//员工性别
    private Date empBirthday; //员工生日
    private int positionId;//员工职务
    private int deptId;   //部门编号
    private BigDecimal empBasicSalary; //基本工资
    private BigDecimal empInsurance;//保险金
    private Date empCreatDate;//创建日期
    private Date empModifyDate; //修改日期
    private int empState;//状态
    private int empModifier; //修改人
    private Position position;//该员工的职务信息
    private BigDecimal  performance;//绩效
    private BigDecimal bonus; //奖金
}
