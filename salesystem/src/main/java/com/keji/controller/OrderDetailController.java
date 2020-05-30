package com.keji.controller;

import com.keji.common.web.BaseController;
import com.keji.pojo.OrderDetail;
import com.keji.service.OrderDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/orderDetailController")
public class OrderDetailController extends BaseController {

    @Resource
    private OrderDetailService orderDetailService;

    @RequestMapping("/findCustOrderDetail")
    public String findCustOrderDetail(String orderId){
        List<OrderDetail> list= orderDetailService.findCustOrderDetail(orderId);
        String result= dealQueryResult(list,list);
        return result;
    }

    @RequestMapping("/updateOrderDetil")
    public String updateOrderDetil(String id,String state){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        orderDetail.setOrderUpdateDate(state);
        int row = orderDetailService.updateOrderDetail(orderDetail);
        if(row>0){
            return dealSuccessResutl("删除成功",null);
        }
        return dealSuccessResutl("失败",null);
    }
}
