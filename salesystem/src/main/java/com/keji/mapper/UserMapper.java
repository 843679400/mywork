package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dcy
 * @date 2019/9/7 19:44
 * @description
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有的用户
     * @return page类型
     */
    Page<UserInfo> findAllUser();


    /**
     * 根据用户名获得用户
     * @param userName 用户名
     * @return 符合用户名的用户
     */
    UserInfo findUserByUserName(@Param("userName") String userName);

    /**
     * 增加用户
     * @param userInfo 要添加用户
     * @return 添加结果
     */
    Integer addUser(UserInfo userInfo);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    Integer deleteUser(@Param("id") Integer id);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    Integer updateUser(UserInfo userInfo);

    /**
     * 给用户增加角色
     * @param userId 用户id
     * @param roleId 角色id
     * @return 增加结果
     */
    Integer addRole(@Param("userId") Integer userId,@Param("roleId") Integer roleId);
}
