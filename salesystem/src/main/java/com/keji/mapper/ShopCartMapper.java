package com.keji.mapper;

import com.keji.pojo.ShopCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopCartMapper {
    //用户查看购物车
    List<ShopCart> findShopCart(ShopCart shopCart);

    //添加购物车
    int addShopCart(ShopCart shopCart);

    //删除购物车
    int delShopCart(int id);

    //修改购物车
    int updateShopCart(ShopCart shopCart);

    //删除该账户的购物车
    int delTheShopCart(ShopCart shopCart);
}
