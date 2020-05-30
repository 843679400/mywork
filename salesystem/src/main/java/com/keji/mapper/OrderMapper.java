package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李天笑
 * @date 2019/9/7 17:12
 * 订单表接口
 */
@Mapper
public interface OrderMapper {
    /**
     * 获取所有订单
     * @return
     */
    Page<Order> getAllOrder(Order order);


    /**
     * 添加订单
     */
    int addOrder(Order order);


    /**
     * 修改订单状态
     * @param orderId
     * @return
     */
    int updateOrder(@Param("orderState") int orderState,@Param("orderId") String orderId);


    /**
     * 根据订单编号查询订单
     * @param orderId
     * @return
     */
    List<Order> findOrder(@Param("orderId") String orderId);

    /**
     * 修改订单为全款
     */
    int updateFullPayment(@Param("orderId") String orderId);


    /**
     * 查询售后订单
     * @param orderId
     * @return
     */
    Order findRefundOrder(@Param("orderId")String orderId);

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    int delOrder(@Param("orderId")String orderId);

    /**
     * 根据用户账号查询用户订单
     * @param order
     * @return
     */
    Page<Order> getUserOrder(Order order);

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
