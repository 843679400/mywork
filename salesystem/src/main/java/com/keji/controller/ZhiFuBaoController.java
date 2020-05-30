package com.keji.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.keji.common.config.AlipayConfig;
import com.keji.common.utils.OrderCodeFactory;
import com.keji.pojo.Order;
import com.keji.pojo.OrderDetail;
import com.keji.pojo.Product;
import com.keji.pojo.ShopCart;
import com.keji.service.AlipayService;
import com.keji.service.imp.OrderDetailServiceImpl;
import com.keji.service.imp.OrderServiceImpl;
import com.keji.service.imp.ProductServiceImpl;
import com.keji.service.imp.ShopCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 支付宝支付
 */
@Controller
@RequestMapping("/payment")
public class ZhiFuBaoController {
    @Autowired
    AlipayService alipayService;
    @Autowired
    ShopCartServiceImpl shopCartService;
    @Autowired
    OrderDetailServiceImpl orderDetailService;
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    ProductServiceImpl productService;


    /**
     * 支付
     * @param pricesum1 总金额
     * @param usernumber 账户id
     * @param response
     * @param request
     */
    @RequestMapping("/pay")
    public void payMent(@RequestParam("pricesum1")String pricesum1, @RequestParam("usernumber")String usernumber, HttpServletResponse response, HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
        //生成订单编号
        String orderId= OrderCodeFactory.getOrderCode(Long.valueOf(usernumber).longValue());
        try {
            alipayService.aliPay(pricesum1,orderId,response,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("支付********************************************************");
        //将购物车商品插入到订单详情表中
        ShopCart shopCart = new ShopCart();
        shopCart.setNumber(usernumber);
        //根据用户账户获取购物车信息
        List<ShopCart> list = shopCartService.findShopCart(shopCart);
        for(ShopCart cart:list){
            OrderDetail orderDetail = new OrderDetail();
            Product product = new Product();
            //订单编号
            orderDetail.setOrderId(orderId);
            //商品编号
            orderDetail.setOrderGooId(cart.getProductId());
            //商品名称
            orderDetail.setOrderPiscounts(cart.getProduct().getProductName());
            //商品图片
            orderDetail.setOrderModifier(cart.getProduct().getPhotopath());
            //商品数量
            orderDetail.setOrderAmount(cart.getProductSum());
            //商品进价
            orderDetail.setOrderPrice(cart.getProduct().getProductPrice());
            //商品售价
            orderDetail.setOrderRemark(cart.getProduct().getPrice());
            //订单明细状态
            orderDetail.setOrderUpdateDate("0");
            //新增订单明细
            orderDetailService.addOrderDetail(orderDetail);
            //商品卖出修改库存
            product.setProductId(Integer.parseInt(cart.getProductId()));
            product.setProductWarning(Integer.parseInt(cart.getNumber()));
            productService.updateProductNum(product);
        }
        //新增订单表
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderCusId(Integer.parseInt(usernumber));
        //订单创建日期
        order.setOrderCreateDate(new Date());
        order.setOrderAggregateAmount(new BigDecimal(pricesum1));
        //通过订单状态判断订单是否受理发货 0表示未受理 1表示受理
        order.setOrderState("0");
        orderService.addOrder(order);
    }

    @RequestMapping("/success")
    public void success(String number){
        //清空该账号的购物车
        ShopCart shopCart1 = new ShopCart();
        shopCart1.setNumber(number);
        shopCartService.delTheShopCart(shopCart1);
    }
}
