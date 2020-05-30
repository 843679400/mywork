package com.keji.service;

import com.keji.pojo.Consumer;

import java.util.List;

public interface ConsumerService {
    //消费者账号注册
    int consumerRegister(Consumer consumer);
    //消费者账号查询
    List<Consumer> login(Consumer consumer);
    //获取账号信息
    List<Consumer> getConsumer(String number);
    //保存消费者账户信息
    int saveConsumer(Consumer consumer);
}
