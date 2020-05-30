package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: sale_System
 * @description: 部门业务层
        * @author: 李东升
        * @create: 2019-09-08 09:06
        **/
public interface DeptService {

    //查询所有部门信息
     PageInfo<Dept> findAllDepts(int pageNum,int pageSize);

    /**
     * 通过部门编号查询一条部门信息
     */
    Dept findDeptById(int id);


    /**
     * 添加一条部门信息
     */
    public int addDept(Dept dept);

    /**
     * 通过编号修改一条部门信息
     */
    public int updateDeptById(Dept dept);

    /**
     * 通过编号删除一条部门信息
     */
    public int deleteDeptById(@Param("id") int id);



}
