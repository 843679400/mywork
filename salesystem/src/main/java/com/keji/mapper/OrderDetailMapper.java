package com.keji.mapper;

import com.keji.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李天笑
 * @date 2019/9/7 19:07
 * 订单详情接口
 */
@Mapper
public interface OrderDetailMapper {

    /**
     * 查询订单详情
     * @return
     */
    List<OrderDetail> findOrderDetail();

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
    List<OrderDetail> findCustOrderDetail(@Param("orderId") String orderId);

    /**
     * 删除订单详情
     * @param orderId
     * @return
     */
    int delOrderDetail(@Param("orderId") String orderId);

    /**
     * 查询年份
     * @return
     */
    List<Integer> findYear();
    /**
     * 查询年份
     * @return
     */
    List<Integer> findMonth();
    /**
     * 查询年份
     * @return
     */
    List<Integer> findDay();

    //修改订单详情为删除状态
    int updateOrderDetail(OrderDetail orderDetail);
}
