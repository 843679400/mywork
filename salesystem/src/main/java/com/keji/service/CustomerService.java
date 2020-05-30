package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Customer;
import com.keji.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: sale
 * @author:lxh
 */


public interface CustomerService {
    //获取所有客户信息
     PageInfo<Customer> findAllCustomer(int pageNum,int pageSize);

    //根据电话查询客户
    public List<Customer> findCustPhone(@Param("phone") String phone);

    //通过客户编号删除客户信息(直接传一个客户对象即可)
    public int delCustomerById(@Param("id") int id);

    //通过id修改一条客户信息
    public int updateCustomerById(Customer customer);


    //添加一条客户信息
    public int addCustomer(Customer customer);
}
