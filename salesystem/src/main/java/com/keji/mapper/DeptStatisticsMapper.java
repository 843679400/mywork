package com.keji.mapper;

import com.keji.pojo.Dept;
import com.keji.pojo.DeptStatistics;
import com.keji.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/9/8.
 */
@Mapper
public interface DeptStatisticsMapper {

    /**
     *查询指定部门内所有员工的销售业绩
     * @param deptName 部门名称
     * @param saleYear 年
     * @param saleMonth 月
     * @return 返回指定部门指定年月份的所有员工的销售信息的集合
     */
    List<DeptStatistics> findDeptStatistics(@Param("deptName") String deptName, @Param("orderYear") int saleYear, @Param("orderMonth") int saleMonth);


}
