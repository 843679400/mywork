package com.keji.service.imp;

import com.keji.mapper.ShopCartMapper;
import com.keji.pojo.ShopCart;
import com.keji.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartMapper shopCartMapper;
    @Override
    public List<ShopCart> findShopCart(ShopCart shopCart) {
        return shopCartMapper.findShopCart(shopCart);
    }

    @Override
    public int addShopCart(ShopCart shopCart) {
        return shopCartMapper.addShopCart(shopCart);
    }

    @Override
    public int delShopCart(int id) {
        return shopCartMapper.delShopCart(id);
    }

    @Override
    public int updateShopCart(ShopCart shopCart) {
        return shopCartMapper.updateShopCart(shopCart);
    }

    @Override
    public int delTheShopCart(ShopCart shopCart) {
        return shopCartMapper.delTheShopCart(shopCart);
    }
}
