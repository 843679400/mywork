package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dcy
 * @date 2019/9/8 10:31
 * @description
 */
@Mapper
public interface RoleMapper {
    /**
     * 根据id查询角色
     * @param roleId
     * @return
     */
    Role findRoleById(@Param("roleId") int roleId);

    /**
     * 根据角色名称查找角色
     * @param roleName 角色名称
     * @return 符合该角色名称的的角色
     */
    Role findRoleByRoleName(@Param("roleName") String roleName);

    /**
     * 查询所有的角色
     * @return
     */
    Page<Role> findAllRole();

    /**
     * 查询所有的角色不查询出权限
     * @return
     */
    Page<Role> findAllRoleNotAuth();

    /**
     * 增加角色
     * @return
     */
    Integer addRole(Role role);

    /**
     * 给角色添加权限
     * @param roleId
     * @param authId
     * @return
     */
    Integer addAuth(@Param("roleId") Integer roleId,@Param("authId") Integer authId);

    /**
     * 删除角色
     * @param roleId 角色id
     * @return 删除结果
     */
    Integer deleteRole(@Param("roleId") Integer roleId);

    /**
     * 查询用户没有的角色
     * @param userId
     * @return
     */
    Page<Role> findUserDontHaveRoles(@Param("userId") Integer userId);

}
