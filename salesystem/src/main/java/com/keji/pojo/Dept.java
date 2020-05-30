package com.keji.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: sale
 * @description: 部门表
 * @author: lxh
 * @create: 2019-09-07 16:58
 **/
@Data
public class Dept {
    private  int deptId;//部门编号
    private String deptName;//部门名称
    private String deptPrincipal;//部门负责人
    private Date deptCreatDate;//创建日期
    private Date deptModifieDate;//修改日期；
    private int deptModifier;//修改人；
    private int deptState;//状态；
    private List<Emp> empList;//部门中的所有员工


}
