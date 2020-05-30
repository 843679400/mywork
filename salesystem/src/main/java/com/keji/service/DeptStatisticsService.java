package com.keji.service;

import com.keji.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * 部门统计
 * Created by Administrator on 2019/9/8.
 */
public interface DeptStatisticsService {

    /**
     * 通过部门名称查询部门信息，同时能够获得部门的所有员工
     * @param deptName
     * @return
     */
    Dept findDeptByDeptName(String deptName);



}