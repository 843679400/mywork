package com.keji.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.github.pagehelper.PageInfo;
import com.keji.common.config.AlipayConfig;
import com.keji.common.utils.OrderCodeFactory;
import com.keji.common.web.BaseController;
import com.keji.pojo.*;
import com.keji.service.CustomerService;
import com.keji.service.OrderService;
import com.keji.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

/**
 * @author 李天笑
 * @date 2019/9/8 15:41
 * 订单类
 */

@RestController
@RequestMapping("/orderController")
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService;

    /**
     * 根据用户账号查询订单信息
     * @return
     */
    @RequestMapping("/getUserOrder")
    public String getUserOrder(String number){
        Order o = new Order();
        o.setOrderCusId(Integer.parseInt(number));
        List<Order> list = orderService.getUserOrder(o);
        String result= dealQueryResult(list,list);
        
        return result;
    }

    /**
     * 获取所有订单信息
     * @return
     */
    @RequestMapping("/getAllorder")
    public String getAllorder(String orderid,String state,int page){
        Order order = new Order();
        order.setOrderId(orderid);
        order.setOrderState(state);
        PageInfo<Order> orderPageInfo = orderService.getAllOrder(page,8,order);
        String result= dealQueryResult(orderPageInfo,orderPageInfo);
        
        return result;
    }

    /**
     * 修改订单状态
     * @return
     */
    @RequestMapping("/updateOrder")
    public String updateOrder(String orderId,int state) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderId +"\","+"\"trade_no\":\"\"}");
        //请求
        String result = alipayClient.execute(alipayRequest).getBody();
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject jsonObject1 = JSON.parseObject(jsonObject.getString("alipay_trade_query_response"));
        if(jsonObject1.getString("msg").equals("Success")) {
            int row = orderService.updateOrder(state, orderId);
            if (row > 0) {
                return dealSuccessResutl("修改成功", "null");
            }
        }else {
            return dealSuccessResutl("该账单未支付", "null");
        }
        return null;

    }

    /**
     * 根据订单编号获取订单信息
     */
    @RequestMapping("/getOrderDetil")
    public String getOrderDetil(String orderId){
        Order o = new Order();
        o.setOrderId(orderId);
        List<Order> list = orderService.getOrderDetail(o);
        String result= dealQueryResult(list,list);
        
        return result;
    }

    /**
     * 获取商品的销售日期
     * @return
     */
    @RequestMapping("/getMonth")
    public String getMonth(){
        List<Order> list = orderService.selectMonth();
        String result= dealQueryResult(list,list);
        System.out.println(result);
        return result;
    }

    /**
     * 根据日期查询商品的销售量，名字，总金额
     * @param date
     * @return
     */
    @RequestMapping("/selectProNameNum")
    public String selectProNameNum(String date){
        Order order = new Order();
        order.setOrderRemark(date);
        List<Order> list = orderService.selectProNameNum(order);
        String result= dealQueryResult(list,list);
        System.out.println(result);
        System.out.println("查询成功");
        return result;
    }
}
