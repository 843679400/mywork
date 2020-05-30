package com.keji.service.imp;

import com.keji.mapper.GatheringMapper;
import com.keji.pojo.Gathering;
import com.keji.service.GatheringService;
import com.keji.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 李天笑
 * @date 2019/9/9 19:38
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GatheringServiceImpl implements GatheringService {

    @Resource
    private GatheringMapper gatheringMapper;
    @Resource
    private OrderService orderService;

    @Override
    public int addGathering(Gathering gathering) {
        //添加还款
        gatheringMapper.addGathering(gathering);
        //修改订单状态 改为全款
        orderService.updateFullPayment(gathering.getGathOrderId());
        return 0;
    }
}
