package com.keji.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.OrderDetailMapper;
import com.keji.mapper.OrderMapper;
import com.keji.mapper.RepositoryMapper;
import com.keji.pojo.Batch;
import com.keji.pojo.Order;
import com.keji.pojo.OrderDetail;
import com.keji.pojo.Product;
import com.keji.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author 李天笑
 * @date 2019/9/9 8:42
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private RepositoryMapper repositoryMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int updateOrder(int yajin, String orderId) {
        return orderMapper.updateOrder(yajin,orderId);
    }

    @Override
    public List<Order> findOrder(String orderId) {
        return orderMapper.findOrder(orderId);
    }

    @Override
    public int updateFullPayment(String orderId) {
        return orderMapper.updateFullPayment(orderId);
    }

    @Override
    public Order findRefundOrder(String orderId) {
        return orderMapper.findRefundOrder(orderId);
    }

    @Override
    public int delOrder(String orderId) {
        orderDetailMapper.delOrderDetail(orderId);
        return orderMapper.delOrder(orderId);
    }

    @Override
    public List<Order> getUserOrder(Order order) {
        return orderMapper.getUserOrder(order);
    }

    @Override
    public PageInfo<Order> getAllOrder(int pageNum, int pageSize, Order order) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Order> page = orderMapper.getAllOrder(order);
        PageInfo<Order> orderPageInfo = new PageInfo<>(page);
        return orderPageInfo;
    }

    @Override
    public List<Order> getOrderDetail(Order order) {
        return orderMapper.getOrderDetail(order);
    }

    @Override
    public List<Order> selectMonth() {
        return orderMapper.selectMonth();
    }

    @Override
    public List<Order> selectProNameNum(Order order) {
        return orderMapper.selectProNameNum(order);
    }
}
