package com.keji.service;


import com.github.pagehelper.PageInfo;
import com.keji.pojo.Authority;
import com.keji.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserService  {
    /**
     * 分页查询用户
     * @param pageNum 第几页 从第1页开始
     * @param pageSize 每页的个数
     * @return PageInfo （）
     */
    PageInfo<UserInfo> findUserByPage(int pageNum, int pageSize);


    /**
     * 根据用户名获得用户
     * @param userName 用户名
     * @return 符合用户名的用户
     */
    UserInfo findUserByUserName(String userName);

    /**
     * 获得该用户所有的权限
     * @return
     */
    List<List<Authority>> finTheUserAllAuth();

    /**
     * 添加用户
     * @param userInfo 要添加的用户信息
     * @return 添加结果
     */
    Integer addUser(UserInfo userInfo);

    /**
     * 删除用户
     * @param id 用户的id
     * @return 删除的结果
     */
    Integer deleteUser(Integer[] id);

    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    Integer updateUser(UserInfo userInfo);

    /**
     * 给用户增加角色
     * @param userId 用户id
     * @param roleIds 角色ids
     * @return 增加结果
     */
    Integer addRole(Integer userId,List<Integer> roleIds);


}
