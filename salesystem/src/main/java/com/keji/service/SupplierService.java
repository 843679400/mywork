package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Supplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sale_System
 * @description: 供货商业务层
 * @author: 李东升
 * @create: 2019-09-08 09:46
 **/

public interface SupplierService {

    //查询所有供货商信息
    public PageInfo<Supplier> findAllSuppliers(int pageNum, int pageSize);
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

}
