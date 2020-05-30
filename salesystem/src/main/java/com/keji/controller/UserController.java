package com.keji.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.JsonUtil;
import com.keji.common.utils.StringUtils;
import com.keji.common.utils.User;
import com.keji.common.web.BaseController;
import com.keji.pojo.Role;
import com.keji.pojo.UserInfo;
import com.keji.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    /**
     * 检查登录
     * @return 登录结果
     */
    @RequestMapping("/login")
    public String checkLogIn(@RequestBody UserInfo userInfo){
        String username = userInfo.getUserName();
        String password = userInfo.getPassword();
        if(StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password)){
            Subject subject  = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username.trim(),password.trim());
            try {
                subject.login(token);
                return JsonUtil.getResponseJson(0,"登录成功",null);
            }catch (Exception e){
                return JsonUtil.getResponseJson(-1,"登录失败",null);
            }
        }else{
            return JsonUtil.getResponseJson(-1,"用户名密码不能为空",null);
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logOut")
    public String logOut(){
        Subject subject  = SecurityUtils.getSubject();
        try{
            subject.logout();
            return dealSuccessResutl("注销成功",1);
        }catch (Exception e){
            return dealSuccessResutl("注销失败",-1);
        }
    }

    /**
     * 获得登录人的信息
     * @return
     */
    @RequestMapping("/getLogInUser")
    public  String getLogInUser(){
        UserInfo userInfo  = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        return dealQueryResult(userInfo,userInfo);
    }
    /**
     * 查询锁有的用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAllUser")
    public String findAllUser(int pageNum,int pageSize){
        PageInfo<UserInfo> pageInfo = userService.findUserByPage(pageNum,pageSize);
        return dealQueryResult(pageInfo,pageInfo);
    }


    /**
     * 添加用户
     * @param userInfo 要添加的用户
     * @return 添加结果
     */
    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        if(StringUtils.isNotEmpty(userInfo)&&StringUtils.isNotBlank(userInfo)){
            UserInfo haveUser = userService.findUserByUserName(userInfo.getUserName());
            if(haveUser==null){
                Integer result = userService.addUser(userInfo);
                return dealSuccessResutl("用户添加",result);
            }else{
                return dealSuccessResutl("用户名已存在",-1);
            }
        }else{
            return dealSuccessResutl("参数有误",-2);
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestBody Integer[] id){
        if(StringUtils.isNotBlank(id)&&StringUtils.isNotEmpty(id)){
            Integer result = userService.deleteUser(id);
            return dealSuccessResutl("删除结果",result);
        }else{
            return JsonUtil.getResponseJson(-1,"参数有误",null);
        }
    }

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody UserInfo userInfo){
        UserInfo logInUserInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNotBlank(userInfo)&&StringUtils.isNotEmpty(userInfo)){
            userInfo.setModifierId(logInUserInfo.getId());
            Integer result = userService.updateUser(userInfo);
            return dealSuccessResutl("修改结果",result);
        }else{
            return JsonUtil.getResponseJson(-1,"参数有误",null);
        }
    }

    /**
     * 根据用户名查询用户
     */
    @RequestMapping("/findTheUserByUserName")
    public String findUserByUserName(String userName){
        if(StringUtils.isNotBlank(userName)&&StringUtils.isNotEmpty(userName)){
            UserInfo userInfo = userService.findUserByUserName(userName);
            userInfo.setPassword("");
            return dealQueryResult(userInfo,userInfo);
        }else{
            return JsonUtil.getResponseJson(-1,"参数有误",null);
        }
    }

    /**
     * 给用户增加角色
     * @param jsonObject
     * @return
     */
    @RequestMapping("/addRole")
    public String addRole(@RequestBody JSONObject jsonObject){
        Integer userId =Integer.parseInt((String)jsonObject.get("userId"));
        List<Integer> roleIds = (ArrayList<Integer>)jsonObject.get("roleIds");
        if(StringUtils.isNotEmpty(userId)&&StringUtils.isNotEmpty(userId)&&
                StringUtils.isNotEmpty(roleIds)&&StringUtils.isNotEmpty(roleIds)){
            Integer result = userService.addRole(userId,roleIds);
            return dealSuccessResutl("增加结果",result);
        }else{
            return JsonUtil.getResponseJson(-1,"传参出错",null);
        }
    }


}
