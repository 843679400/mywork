package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author dcy
 * @date 2019/9/8 9:17
 * @description 员工持久层
 */
@Mapper
public interface EmpMapper {
    /**
     * 查询所有的员工信息
     *
     * @return 所有的员工信息
     */
    Page<Emp> findAllEmps();

    /**
     * 根据员工编号查询员工
     *
     * @param empNumber
     * @return
     */
    Emp findEmpByEmpNumber(@Param("empNumber") String empNumber);

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

    /**
     * 获得该员工某年某月的销售业绩
     * @param empId 员工id
     * @param year 年
     * @param month 月
     * @return 业绩
     */
    BigDecimal getEmpAccount(@Param("empId") int empId, @Param("year") int year, @Param("month") int month);

    /**
     * 根据部门id查询员工
     * @param deptId
     * @return
     */
    List<Emp> findEmpsByDeptId(@Param("deptId") int deptId);



}
