package com.keji.mapper;

import com.keji.pojo.Gathering;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 李天笑
 * @date 2019/9/7 19:32
 */
@Mapper
public interface GatheringMapper {
    List<Gathering> findGathering();

    /**
     * 添加还款信息
     * @param gathering
     * @return
     */
    int addGathering(Gathering gathering);
}
