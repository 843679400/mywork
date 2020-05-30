package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: sale
 * @description:职务表现层
 * @author: lxh
 * @create: 2019-09-08 10:11
 **/
public interface PositionService {
    //获取所有职务信息
    PageInfo<Position> findAllPosition(int pageNum,int pageSize);
    //增加一条职务信息
    int addPosition(Position Position);

    //通过编号删除职务信息
    int delPositionById(@Param("id") int id);

    //通过id修改一条职务信息
    int updatePositionById(Position Position);

    /**
     * 通过编号查询一条职务信息
     */
    Position findPositionById(@Param("id") int id);

}
