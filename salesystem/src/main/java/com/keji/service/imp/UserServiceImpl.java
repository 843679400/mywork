package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.RoleMapper;
import com.keji.mapper.UserMapper;
import com.keji.pojo.Authority;
import com.keji.pojo.Role;
import com.keji.pojo.UserInfo;
import com.keji.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author dcy
 * @date 2019/9/7 19:56
 * @description
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    /**
     * 分页查询用户
     * @param pageNum  第几页 从第1页开始
     * @param pageSize 每页的个数
     * @return PageInfo （）
     */
    @Override
    public PageInfo<UserInfo> findUserByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<UserInfo> userPage = userMapper.findAllUser();
        PageInfo<UserInfo> goodsPageInfo = new PageInfo<UserInfo>(userPage);
        return goodsPageInfo;
    }

    @Override
    public UserInfo findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    /**
     * 获得该用户所有的权限
     * @return
     */
    @Override
    public List<List<Authority>>  finTheUserAllAuth() {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Set<Authority> allAuth = new HashSet<>();
        for (Role role : userInfo.getRoles()) {//获得每个角色的所有权限
            Role middleRole = roleMapper.findRoleById(role.getId());
            for (Authority authority : middleRole.getAuthorities()) {
                allAuth.add(authority);
            }
        }
        List<Authority> menu = new ArrayList<>();
        List<Authority> childMenu = new ArrayList<>();
        List<List<Authority>> result = new ArrayList<>();
        for (Authority authority : allAuth) {
            if(authority.getParId()==0){
                menu.add(authority);
            }else{//获得子菜单
                childMenu.add(authority);
            }
        }
        menu.sort(new Comparator<Authority>() {
            @Override
            public int compare(Authority o1, Authority o2) {
                return o1.getId()-o2.getId();
            }
        });
        childMenu.sort(new Comparator<Authority>() {
            @Override
            public int compare(Authority o1, Authority o2) {
                return o1.getId()-o2.getId();
            }
        });
        result.add(menu);
        result.add(childMenu);
        return result;
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @Override
    public Integer addUser(UserInfo userInfo) {
        return userMapper.addUser(userInfo);
    }

    /**
     * 删除用户
     * @param id 用户的id
     * @return 删除的结果
     */
    @Override
    public Integer deleteUser(Integer[] id) {
        for (int i = 0; i < id.length; i++) {
             try{
                 userMapper.deleteUser(id[i]);
             }catch (Exception e){
                 return -1;
             }
        }
        return 1;
    }

    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    @Override
    public Integer updateUser(UserInfo userInfo) {
        return userMapper.updateUser(userInfo);
    }

    /**
     * 给用户增加角色
     * @param userId 用户id
     * @param roleIds 角色ids
     * @return 增加结果
     */
    @Override
    public Integer addRole(Integer userId, List<Integer> roleIds) {
        for (Integer roleId : roleIds) {
            try{
                userMapper.addRole(userId,roleId);
            }catch (Exception e){
                return -1;
            }
        }
        return 1;
    }



}
