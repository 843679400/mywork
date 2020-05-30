package com.keji.service.imp;

import com.keji.mapper.DeptMapper;
import com.keji.mapper.SalaryBillsMapper;
import com.keji.pojo.Dept;
import com.keji.pojo.Emp;

import com.keji.pojo.SalaryBills;
import com.keji.service.SalaryBillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 成雨齐
 * @date 2019/9/8 11:23
 */
@Service
public class SalaryBillsServiceImpl implements SalaryBillsService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private SalaryBillsMapper salaryBillsMapper;

    @Override
    public List<Emp> findTheDeptAllEmp(Integer deptId, Date beginDate, Date endDate) {
       Dept dept =  deptMapper.findDeptById(deptId);
       List<Emp> emps = dept.getEmpList();
       if(emps!=null){
           for(Emp emp : emps){
               BigDecimal performance = salaryBillsMapper.getTheEmpPerformance(emp.getEmpNumber(),beginDate,endDate);
               emp.setPerformance(performance);
           }
       }
       return emps;
    }

    /**
     * 添加工资单记录
     * @param salaryBills
     * @return
     */
    @Override
    public int addSalary(SalaryBills salaryBills) {
        return salaryBillsMapper.addSalary(salaryBills);
    }

    /**
     * 根据日期和员工编号查询对应的工资单信息
     * @param empNumber
     * @param data
     * @return
     */
    @Override
    public SalaryBills findSalaryBillsByEmpId(Integer empNumber, String data) {
        return salaryBillsMapper.findSalaryByEmpNumberData(empNumber,data);
    }
}
