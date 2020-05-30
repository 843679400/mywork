package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.DeptMapper;
import com.keji.pojo.Customer;
import com.keji.pojo.Dept;
import com.keji.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;


    @Override
    public PageInfo<Dept> findAllDepts(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Dept> deptPage=deptMapper.findAllDepts();
        PageInfo<Dept> deptPageInfo=new PageInfo<>(deptPage);
        return deptPageInfo;
    }

    @Override
    public Dept findDeptById(int id) {
        return deptMapper.findDeptById(id);
    }

    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public int updateDeptById(Dept dept) {
        return deptMapper.updateDeptById(dept);
    }

    @Override
    public int deleteDeptById(int id) {
        return deptMapper.deleteDeptById(id);
    }
}
