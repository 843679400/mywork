package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 李天笑
 * @date 2019/9/9 8:42
 * 订单业务层
 */
public interface OrderService {
    /**
     * 添加订单
     */
    /**
     *
     * @param order 新增订单
     * @return
     */
    int addOrder(Order order);

    /**
     * 修改订单状态
     * @param
     * @param orderId
     * @return
     */
    int updateOrder(int orderState,String orderId);

    /**
     * 根据订单编号查询订单
     * @param orderId
     * @return
     */
    List<Order> findOrder(String orderId);

    /**
     * 修改订单为全款
     */
    int updateFullPayment(String orderId);

    /**
     * 查询售后订单
     * @param orderId
     * @return
     */
    Order findRefundOrder(String orderId);

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    int delOrder(String orderId);

    /**
     * 根据用户账号查询用户订单
     * @param order
     * @return
     */
    List<Order> getUserOrder(Order order);

    /**
     * 获取所有订单
     * @return
     */
    PageInfo<Order> getAllOrder(int pageNum,int pageSize,Order order);

    /**
     * 根据订单编号获取订单详情
     * @param order
     * @return
     */
    List<Order> getOrderDetail(Order order);

    /**
     * 查询订单日期  年 月
     * @return
     */
    List<Order> selectMonth();

    /**
     * 根据日期查询商品的销售量
     * @return
     */
    List<Order> selectProNameNum(Order order);
}
