package com.keji.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.keji.common.utils.JsonUtil;
import com.keji.common.utils.StringUtils;
import com.keji.common.web.BaseController;
import com.keji.pojo.Role;
import com.keji.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有的角色
     * @return 该页的所有角色
     */
    @RequestMapping("/findAllRole")
    public String findAllRole(Integer pageNum,Integer pageSize){
        if(StringUtils.isNotEmpty(pageNum)&&StringUtils.isNotEmpty(pageNum)){
            PageInfo<Role> pageInfo  = roleService.findAllRole(pageNum,pageSize);
            return dealQueryResult(pageInfo,pageInfo);
        }else{
            return JsonUtil.getResponseJson(-1,"传参出错",null);
        }
    }


    /**
     * 根据id查询角色
     * @param roleId
     * @return 符合该id的角色
     */
    @RequestMapping("/findRoleById")
    public String findRoleById(Integer roleId){
        if(StringUtils.isNotEmpty(roleId)){
            Role role = roleService.findRoleById(roleId);
            return dealQueryResult(role,role);
        }else {
            return JsonUtil.getResponseJson(-1,"传参出错",null);
        }
    }

    /**
     * 根据角色名称查找角色
     * @param roleName 角色名称
     * @return 符合该角色名称的的角色
     */
    @RequestMapping("/findRoleByRoleName")
    public String findRoleByRoleName(String roleName) {
        if(StringUtils.isNotEmpty(roleName)&&StringUtils.isNotEmpty(roleName)){
            Role role = roleService.findRoleByRoleName(roleName);
            return dealQueryResult(role,role);
        }else{
            return JsonUtil.getResponseJson(-1,"传参出错",null);
        }
    }


    /**
     * 增加角色
     * @return
     */
    @RequestMapping("/addRole")
    public String addRole(@RequestBody Role role) {
        if(StringUtils.isNotEmpty(role)&&StringUtils.isNotEmpty(role)){
            Integer result = roleService.addRole(role);
            return dealSuccessResutl("添加结果",result);
        }else{
            return JsonUtil.getResponseJson(-1,"传参出错",null);
        }
    }

    /**
     * 给角色添加权限
     * @return
     */
    @RequestMapping("/addAuth")
    public String addAuth(@RequestBody JSONObject jsonObject) {
        Integer roleId =Integer.parseInt((String)jsonObject.get("roleId"));
        List<Integer> authIds = (ArrayList<Integer>)jsonObject.get("authIds");
         if(StringUtils.isNotEmpty(roleId)&&StringUtils.isNotEmpty(roleId)&&
                StringUtils.isNotEmpty(authIds)&&StringUtils.isNotEmpty(authIds)){
            Integer result = roleService.addAuth(roleId,authIds);
            return dealSuccessResutl("增加结果",result);
        }else{
            return JsonUtil.getResponseJson(-1,"传参出错",null);
        }
    }

    /**
     * 删除角色
     * @param roleIds 角色id
     * @return 删除结果
     */
    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestBody Integer[] roleIds) {
        if(StringUtils.isNotEmpty(roleIds)&&StringUtils.isNotEmpty(roleIds)){
            Integer result = roleService.deleteRole(roleIds);
            return dealSuccessResutl("删除结果",result);
        }else{
            return JsonUtil.getResponseJson(-1,"传参出错",null);
        }
    }

    /**
     * 查询用户不存在的角色
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @RequestMapping("/findUserDontHaveRoles")
    public String findUserDontHaveRoles(Integer pageNum, Integer pageSize, Integer userId) {
        if(StringUtils.isNotEmpty(pageNum)&&StringUtils.isNotEmpty(pageNum)){
            PageInfo<Role> pageInfo  = roleService.findUserDontHaveRoles(pageNum,pageSize,userId);
            return dealQueryResult(pageInfo,pageInfo);
        }else{
            return JsonUtil.getResponseJson(-1,"传参出错",null);
        }
    }
}
