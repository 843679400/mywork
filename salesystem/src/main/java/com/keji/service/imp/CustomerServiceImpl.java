package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.CustomerMapper;
import com.keji.pojo.Customer;
import com.keji.pojo.Repository;
import com.keji.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sale
 * @description: 客户业务层
 * @author: lxh
 * @create: 2019-09-08 09:17
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public PageInfo<Customer> findAllCustomer(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Customer> customerPage = customerMapper.findAllCustomer();
        PageInfo<Customer> customersPageInfo = new PageInfo<>(customerPage);
        return customersPageInfo;
    }

    @Override
    public List<Customer> findCustPhone(String phone) {
        return customerMapper.findCustPhone(phone);
    }

    @Override
    public int addCustomer(Customer customer) {

        return customerMapper.addCustomer(customer);
    }

    @Override
    public int delCustomerById(int id) {
        return customerMapper.delCustomerById(id);
    }

    @Override
    public int updateCustomerById(Customer customer) {
        return customerMapper.updateCustomerById(customer);
    }
}
