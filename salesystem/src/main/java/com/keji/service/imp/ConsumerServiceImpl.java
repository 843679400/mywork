package com.keji.service.imp;

import com.keji.mapper.ConsumerMapper;
import com.keji.pojo.Consumer;
import com.keji.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public int consumerRegister(Consumer consumer) {
        return consumerMapper.consumerRegister(consumer);
    }

    @Override
    public List<Consumer> login(Consumer consumer) {
        return consumerMapper.login(consumer);
    }

    @Override
    public List<Consumer> getConsumer(String number) {
        return consumerMapper.getConsumer(number);
    }

    @Override
    public int saveConsumer(Consumer consumer) {
        return consumerMapper.saveConsumer(consumer);
    }
}
