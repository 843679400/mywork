package com.keji.service;

import com.keji.pojo.Gathering;

/**
 * @author 李天笑
 * @date 2019/9/9 19:37
 */
public interface GatheringService {
    /**
     * 添加还款信息
     * @param gathering
     * @return
     */
    int addGathering(Gathering gathering);
}
