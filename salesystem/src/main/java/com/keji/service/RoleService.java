package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Role;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * 角色的服务层
 */
public interface RoleService {
    /**
     * 根据id插叙角色
     * @param roleId
     * @return 符合该id的角色
     */
    Role findRoleById(int roleId);

    /**
     * 查询所有的角色
     * @return 该页的所有角色
     */
    PageInfo<Role> findAllRole(int pageNum,int pageSize);

    /**
     * 根据角色名称查找角色
     * @param roleName 角色名称
     * @return 符合该角色名称的的角色
     */
    Role findRoleByRoleName( String roleName);

    /**
     * 增加角色
     * @return
     */
    Integer addRole(Role role);

    /**
     * 给角色添加权限
     * @param roleId
     * @param authIds
     * @return
     */
    Integer addAuth(Integer roleId, List<Integer> authIds);

    /**
     * 删除角色
     * @param roleIds 角色id
     * @return 删除结果
     */
    Integer deleteRole(Integer[] roleIds);

    /**
     * 查询用户没有的角色
     * @param userId
     * @return
     */
    PageInfo<Role> findUserDontHaveRoles(Integer pageNum,Integer pageSize,Integer userId);

}
