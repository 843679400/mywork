package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: sale
 * @description: 职务持久层
 * @author: lxh
 * @create: 2019-09-08 09:58
 **/
@Mapper
public interface PositionMapper {

    //增加一条职务信息
     int addPosition(Position Position);

    //通过编号删除职务信息
     int delPositionById(@Param("id") int id);

    //通过id修改一条职务信息
    int updatePositionById(Position Position);

    /**
     * 查询所有的职务
     * @return page类型
     */
    Page<Position> findAllPosition();

    /**
     * 通过编号查询一条职务信息
     */
    Position findPositionById(@Param("id") int id);

}
