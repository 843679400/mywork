package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.SupplierMapper;
import com.keji.pojo.Product;
import com.keji.pojo.Supplier;
import com.keji.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sale_System
 * @description: 供货商业务层实现类
 * @author: 李东升
 * @create: 2019-09-08 09:55
 **/
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    //查询所有供货商信息

    @Override
    public PageInfo<Supplier> findAllSuppliers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Supplier> supplierPage=supplierMapper.findAllSuppliers();
        PageInfo<Supplier> supplierPageInfo=new PageInfo<>(supplierPage);
        return supplierPageInfo;

    }

    //添加供货商信息
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.addSupplier(supplier);
    }

    //修改供货商信息
    @Override
    public int updateSupplierById(Supplier supplier) {
        return supplierMapper.updateSupplierById(supplier);
    }
    //删除供货商信息
    @Override
    public int deleteSupplierById(int id) {

        return supplierMapper.deleteSupplierById(id);
    }
}
