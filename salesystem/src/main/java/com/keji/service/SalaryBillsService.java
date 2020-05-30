package com.keji.service;

import com.keji.pojo.Emp;
import com.keji.pojo.SalaryBills;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 成雨齐
 * @date 2019/9/8 11:09
 */

public interface SalaryBillsService {

    /**
     * 根据部门id查询该部门下的所有员工，并且计算好绩效
     *
     * @param deptId    部门id
     * @param beginDate 起始日期
     * @param endDate   结束日期
     * @return 满足这些条件的员工
     */
    List<Emp> findTheDeptAllEmp(Integer deptId, Date beginDate, Date endDate);

    /**
     * 向工资单中添加一条工资记录（ 一个SalaryBills对象）
     *
     * @param salaryBills
     * @return
     */
    int addSalary(SalaryBills salaryBills);

    SalaryBills findSalaryBillsByEmpId(Integer empNumber, String data);
}
