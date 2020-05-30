package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.PositionMapper;
import com.keji.pojo.Customer;
import com.keji.pojo.Position;
import com.keji.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sale
 * @description: 职务业务层
 * @author: lxh
 * @create: 2019-09-08 10:15
 **/
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Override
    public PageInfo<Position> findAllPosition(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Position> positionPage=positionMapper.findAllPosition();
        PageInfo<Position> positionPageInfo=new PageInfo<>(positionPage);
        return positionPageInfo;
    }

    @Override
    public int addPosition(Position Position) {
        return positionMapper.addPosition(Position);
    }

    @Override
    public int delPositionById(int id) {
        return positionMapper.delPositionById(id);
    }

    @Override
    public int updatePositionById(Position Position) {
        return positionMapper.updatePositionById(Position);
    }

    @Override
    public Position findPositionById(int id) {
        return positionMapper.findPositionById(id);
    }
}
