package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.EmpMapper;
import com.keji.pojo.Customer;
import com.keji.pojo.Emp;
import com.keji.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author dcy
 * @date 2019/9/8 9:34
 * @description
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 根据员工编号查询员工
     * @param empNumber 员工编号
     * @return 符合该编号的员工
     */
    @Override
    public Emp findEmpByEmpNumber(String empNumber) {
        Emp emp = empMapper.findEmpByEmpNumber(empNumber);
        return emp;
    }


    /**
     * 查询所有的员工信息
     * @return 所有的员工信息
     */
    @Override
    public PageInfo<Emp> findAllEmp(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Emp> empPage=empMapper.findAllEmps();
        PageInfo<Emp> empPageInfo=new PageInfo<>(empPage);
        return empPageInfo;
    }

    /**
     * 获得员工某年某月的销售
     * @param empId 员工id
     * @param year 年
     * @param month 月
     * @return 销售额
     */
    @Override
    public BigDecimal getEmpAccount(int empId, int year, int month) {
        BigDecimal account = empMapper.getEmpAccount(empId,year,month);
        return  account;
    }

    @Override
    public int addEmp(Emp emp) {

        return empMapper.addEmp(emp);
    }

    @Override
    public int updateEmpById(Emp emp) {
        return empMapper.updateEmpById(emp);
    }

    @Override
    public int deleteEmpById(int id) {
        return empMapper.deleteEmpById(id);
    }
}
