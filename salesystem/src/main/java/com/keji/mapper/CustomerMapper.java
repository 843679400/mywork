package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lxh
 * 订单详情接口:客户持久层
 */
@Mapper
public interface CustomerMapper {
    //查询客户所有信息
    Page<Customer> findAllCustomer();

    //通过客户编号查询一条客户信息
    Customer findCustomerById(@Param("id") int id);

    //通过客户编号删除客户信息(直接传一个客户对象即可)
    public int delCustomerById(@Param("id") int id);

    //通过id修改一条客户信息
    public int updateCustomerById(Customer customer);


    //添加一条客户信息
    public int addCustomer(Customer customer);

    //根据电话查询客户
    public List<Customer> findCustPhone(@Param("phone") String phone);
}
