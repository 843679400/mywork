package com.keji.mapper;

import com.keji.pojo.Consumer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 消费者账号注册
 */
@Mapper
public interface ConsumerMapper {
    //消费者账号注册
    int consumerRegister(Consumer consumer);
    //消费者账号验证
    List<Consumer> login(Consumer consumer);
    //获取账号信息
    List<Consumer> getConsumer(String number);
    //保存消费者账户信息
    int saveConsumer(Consumer consumer);
}
