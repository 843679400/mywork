package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: sale_System
 * @description: 部门数据层
 * @author: 李东升
 * @create: 2019-09-08 08:58
 **/
@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门信息
     */
     Page<Dept> findAllDepts();

    /**
     * 通过部门编号查询一条部门信息
     */
     Dept findDeptById(@Param("id") int id);

    /**
     * 添加一条部门信息
     */
     int addDept(Dept dept);

    /**
     * 通过编号修改一条部门信息
     */
     int updateDeptById(Dept dept);

    /**
     * 通过编号删除一条部门信息
     */
     int deleteDeptById(@Param("id") int id);

    /**
     * 根据部门名称查询部门
     * @param deptName 部门名称
     * @return 符合名称的部门
     */
    Dept findDeptByDeptName(@Param("deptName") String deptName);
}
