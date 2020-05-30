package com.keji.controller;

import com.keji.common.utils.JsonUtil;
import com.keji.common.utils.StringUtils;
import com.keji.common.web.BaseController;
import com.keji.pojo.Dept;
import com.keji.service.DeptStatisticsService;
import com.keji.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping("/statistics")
public class DeptStatisticsController extends BaseController {

    @Autowired
    private DeptStatisticsService deptStatisticsService;

    @Autowired
    private EmpService empService;

    /**
     * 根据部门名称获得部门，能够获得部门中的员工信息
     * @param deptName
     * @return
     */
    @RequestMapping("/findDeptByName")
    public  String findDeptByDeptName(String deptName){
        if(StringUtils.isNotEmpty(deptName)&& StringUtils.isNotBlank(deptName)){
            Dept dept = deptStatisticsService.findDeptByDeptName(deptName);
            return dealQueryResult(dept,dept);
        }else{
            return JsonUtil.getResponseJson(-1,"部门名称输入错误",null);
        }
    }


    /**
     * 查询员工的某年某月的工资
     * @param empId 员工id
     * @param year 年
     * @param month 月
     * @return 员工销售额
     */
    @RequestMapping("/findEmpAccount")
    public String findEmpAccount(Integer empId,Integer year,Integer month){
        if(StringUtils.isNotBlank(empId)&& StringUtils.isNotBlank(year)&& StringUtils.isNotBlank(month)){
            BigDecimal account = empService.getEmpAccount(empId,year,month);
            return  dealQueryResult(account,account);
        }else{
            return JsonUtil.getResponseJson(-1,"输入参数有误",null);
        }
    }
}
