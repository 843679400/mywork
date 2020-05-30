package com.keji.service;

import com.keji.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李天笑
 * @date 2019/9/9 9:11
 * 订单详情业务类
 */
public interface OrderDetailService {

    /**
     * 添加订单详情
     * @param orderDetail
     * @return
     */
    int addOrderDetail(OrderDetail orderDetail);

    /**
     *根据订单编号返回结算页面的订单信息
     * @param orderId
     * @return
     */
    List<OrderDetail> findCustOrderDetail(String orderId);

    //修改订单详情为删除状态
    int updateOrderDetail(OrderDetail orderDetail);
}
