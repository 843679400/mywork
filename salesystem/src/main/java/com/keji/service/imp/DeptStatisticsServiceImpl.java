package com.keji.service.imp;

import com.keji.mapper.DeptMapper;
import com.keji.pojo.Dept;
import com.keji.service.DeptStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/9/8.
 */
@Service
public class DeptStatisticsServiceImpl implements DeptStatisticsService {

    @Autowired
    private DeptMapper deptMapper;
    /**
     * 通过部门名称查询部门信息，同时能够获得部门的所有员工
     * @param deptName
     * @return
     */
    @Override
    public Dept findDeptByDeptName(String deptName) {
        Dept dept = deptMapper.findDeptByDeptName(deptName);
        return dept;
    }


}
