package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Customer;
import com.keji.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author dcy
 * @date 2019/9/8
 * Content:员工业务层
 */
public interface EmpService {
    /**
     * 根据员工编号查询一条员工信息
     *
     * @param empNumber 员工编号
     * @return 符合该编号的员工
     */
    Emp findEmpByEmpNumber(String empNumber);

    /**
     * 查询所有的员工信息
     * @return 所有的员工信息
     */
    PageInfo<Emp> findAllEmp(int pageNum,int pageSize);

    /**
     * 获得员工某年某月的销售
     * @param empId 员工id
     * @param year 年
     * @param month 月
     * @return 销售额
     */
    BigDecimal getEmpAccount(int empId, int year, int month);

    /**
     * 添加一条员工信息
     */
    int addEmp(Emp emp);

    /**
     * 通过员工编号修改一条员工信息
     */
    int updateEmpById(Emp emp);

    /**
     * 通过员工编号删除一条员工信息.
     *
     * @param id
     * @return
     */
    int deleteEmpById(@Param("id") int id);

}
