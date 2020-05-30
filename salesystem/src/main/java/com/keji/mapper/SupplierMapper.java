package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: sale_System
 * @description: 供货商数据层
 * @author: 李东升
 * @create: 2019-09-08 09:40
 **/
@Mapper
public interface SupplierMapper {

    /**
     * 查询所有供货商信息
     */
    public Page<Supplier> findAllSuppliers();

    /**
     * 添加一条供货商信息
     */
    public int addSupplier(Supplier supplier);

    /**
     * 通过id修改一条供货商信息
     */
    public int updateSupplierById(Supplier supplier);

    /**
     * 通过id删除一条供货商信息
     */
    public int deleteSupplierById(@Param("id") int id);

    /**
     * 通过id查询一条供货商信息
     */
    public Supplier findSupplierById(@Param("id") int id);

}
