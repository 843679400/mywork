package com.keji.service.imp;

import com.keji.mapper.OrderDetailMapper;
import com.keji.pojo.OrderDetail;
import com.keji.service.OrderDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李天笑
 * @date 2019/9/9 9:12
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.addOrderDetail(orderDetail);
    }

    @Override
    public List<OrderDetail> findCustOrderDetail(String orderId) {
        return orderDetailMapper.findCustOrderDetail(orderId);
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.updateOrderDetail(orderDetail);
    }
}
