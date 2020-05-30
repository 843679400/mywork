package com.keji.controller;

import com.keji.common.web.BaseController;
import com.keji.pojo.ShopCart;
import com.keji.service.imp.ProductServiceImpl;
import com.keji.service.imp.ShopCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopCart")
public class ShopCartController extends BaseController {

    @Autowired
    private ShopCartServiceImpl shopCartService;


    /**
     * 根据用户账号获得购物车信息
     * @param number
     * @return
     */
    @RequestMapping("/findShopCart")
    public String findShopCart(String number){
        ShopCart shopCart = new ShopCart();
        shopCart.setNumber(number);
        List<ShopCart> list=shopCartService.findShopCart(shopCart);
        String result = dealQueryResult(list,list);
        
        return result;
    }

    /**
     * 添加商品到购物车
     * @return
     */
    @RequestMapping("addShopCart")
    public String addShopCart(String number,String id,int num){
        ShopCart shopCart = new ShopCart();
        shopCart.setNumber(number);
        shopCart.setProductId(id);
        shopCart.setProductSum(num);
        int row = shopCartService.addShopCart(shopCart);
        if(row>0){
            return dealSuccessResutl("添加购物车成功",null);
        }
        return null;
    }

    /**
     * 删除购物车
     * @return
     */
    @RequestMapping("/delshopCart")
    public String delshopCart(int id){
        int row = shopCartService.delShopCart(id);
        if(row>0){
            return dealSuccessResutl("删除购物车成功",null);
        }
        return null;
    }

    /**
     * 修改购物车
     * @return
     */
    @RequestMapping("/updateShopCart")
    public String updateShopCart(int id,int num){
        ShopCart shopCart = new ShopCart();
        shopCart.setId(id);
        shopCart.setProductSum(num);
        int row = shopCartService.updateShopCart(shopCart);
        if(row>0){
            return dealSuccessResutl("修改购物车成功",null);
        }
        return null;
    }
}
