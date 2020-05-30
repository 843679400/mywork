package com.keji.mapper;

import com.keji.pojo.SalaryBills;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 成雨齐
 * @date 2019/9/7 20:17
 */
@Mapper
public interface SalaryBillsMapper {

    /**
     * 查询员工的绩效
     * @param empNumber 员工的编号
     * @param beginDate 起始日期
     * @param endDate 结束日期
     * @return 该员工的绩效
     */
    BigDecimal  getTheEmpPerformance(@Param("empNumber") Integer empNumber,
                                     @Param("beginDate") Date beginDate,
                                     @Param("endDate") Date endDate);

    /**
     *  向工资单中添加一条工资记录（ 一个SalaryBills对象）
     * @param salaryBills
     * @return
     */
    int addSalary(SalaryBills salaryBills);

    /**
     * 根据日期和员工编号查询对应的工资单信息
     * @param empNumber
     * @param date
     * @return
     */
    SalaryBills findSalaryByEmpNumberData(@Param("empNumber") Integer empNumber,
                                          @Param("date") String date);
}
