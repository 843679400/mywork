package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.AuthorityMapper;
import com.keji.mapper.RoleMapper;
import com.keji.pojo.Authority;
import com.keji.pojo.Role;
import com.keji.service.RoleService;
import jdk.jfr.events.ExceptionThrownEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author dcy
 * @date 2019/9/11 8:55
 * @description
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;
    /**
     * 根据id插叙角色
     * @param roleId
     * @return 符合该id的角色
     */
    @Override
    public Role findRoleById(int roleId) {
        Role role = roleMapper.findRoleById(roleId);
        return role;
    }

    /**
     * 查询所有的角色
     * @return 该页的所有角色
     */
    @Override
    public PageInfo<Role> findAllRole(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Role> rolePage = roleMapper.findAllRoleNotAuth();
        PageInfo<Role> rolePageInfo = new PageInfo<>(rolePage);
        return rolePageInfo;
    }

    /**
     * 通过角色名字查询角色
     * @param roleName 角色名称
     * @return
     */
    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleMapper.findRoleByRoleName(roleName);
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @Override
    public Integer addRole(Role role) {
        return roleMapper.addRole(role);
    }

    /**
     * 给角色添加权限
     * @param roleId
     * @param authIds
     * @return
     */
    @Override
    public Integer addAuth(Integer roleId, List<Integer> authIds) {
        Set<Integer> authParIds = new HashSet<>();

        for (Integer authId : authIds) {
            try{
                roleMapper.addAuth(roleId,authId);
                Authority parAuth = authorityMapper.findAuthorityById(authId);
                authParIds.add(parAuth.getParId());
            }catch (Exception e){
                return -1;
            }
        }
        for (Integer authParId : authParIds) {
            try{
                roleMapper.addAuth(roleId,authParId);
            }catch (Exception e){
                return -1;
            }
        }
        return 1;
    }

    /**
     * 删除角色
     * @param roleIds 角色id
     * @return
     */
    @Override
    public Integer deleteRole(Integer[] roleIds) {
        for (Integer roleId : roleIds) {
            try{
                roleMapper.deleteRole(roleId);
            }catch (Exception e){
                return -1;
            }
        }
        return 1;
    }

    /**
     * 查询用户没有的角色
     * @param pageNum
     * @param pageSize
     * @param userId
     * @return
     */
    @Override
    public PageInfo<Role> findUserDontHaveRoles(Integer pageNum, Integer pageSize, Integer userId) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Role> rolePage = roleMapper.findUserDontHaveRoles(userId);
        PageInfo<Role> rolePageInfo = new PageInfo<>(rolePage);
        return  rolePageInfo;
    }

}
