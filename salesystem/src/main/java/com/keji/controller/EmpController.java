package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.utils.JsonUtil;
import com.keji.common.utils.StringUtils;
import com.keji.common.web.BaseController;
import com.keji.mapper.EmpMapper;
import com.keji.pojo.Customer;
import com.keji.pojo.Emp;
import com.keji.pojo.Position;
import com.keji.service.EmpService;
import com.keji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author dcy
 * @date 2019/9/8 9:36
 * @description
 */
@RestController
@RequestMapping("/emp")
public class EmpController extends BaseController {


    @Autowired
    private EmpService empService;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private UserService userService;

   /**
     *
     * @param empNumber 员工编号
     * @return 符合该编号的员工
     */
    @RequestMapping("/findEmpByEmpNumber")
    public String findEmpByEmpNumber(String empNumber){
        if(StringUtils.isNotEmpty(empNumber)&&StringUtils.isNotBlank(empNumber)){
            Emp emp = empService.findEmpByEmpNumber(empNumber);
            return dealQueryResult(emp,emp);
        }else{
            return JsonUtil.getResponseJson(-1,"员工编号错误",null);
        }
    }

    /**
     * 获取所有员工信息
     * @return
     */
    @RequestMapping("/findAllEmps")
    public String findAllEmps(int page){
        PageInfo<Emp> empPageInfo = empService.findAllEmp(page,2);
        String emp =dealQueryResult(empPageInfo,empPageInfo);
        return emp;

    }

    @PostMapping("/addEmp")
    public String addEmp(Emp emp, Principal principal,String Birthday)throws ParseException {
       /* String name= principal.getName();    //
        UserInfo user= userService.findUserByUserName(name);
        product.setModifierId(user.getId());*/

       //将前端页面的日期转储进数据库要进行的日期转换
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = format.parse(Birthday);
        emp.setEmpCreatDate(date);

        int row=empService.addEmp(emp);
        if(row==0){
            return dealSuccessResutl("添加信息失败",null);
        }
        return dealSuccessResutl("成功添加信息",null);
    }


     @PostMapping("/updateEmpById")
    public String updateEmpById(Emp emp){
     int row = empService.updateEmpById(emp);
     if(row==0){
         return dealSuccessResutl("修改信息失败",null);
     }
     return dealSuccessResutl("修改信息成功",null);
    }
    @RequestMapping("/findEmpByEmpNumber1")
    public String findEmpByEmpNumber1(String empNumber){
        Emp emp =empMapper.findEmpByEmpNumber(empNumber);
        String json=dealQueryResult(emp,emp);
        return json;
    }

    @PostMapping("/deleteEmpById")
    public String deleteEmpById(int empId){
        int row=empMapper.deleteEmpById(empId);
        if(row==0){
            return dealSuccessResutl("删除信息失败",null);
        }
        return dealSuccessResutl("删除信息成功",null);

    }

}


