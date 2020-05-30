package com.keji.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keji.mapper.AuthorityMapper;
import com.keji.pojo.Authority;
import com.keji.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dcy
 * @date 2019/9/15 11:39
 * @description
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    /**
     * 查询出模块对应的权限
     * @return 权限的集合
     */
    @Override
    public PageInfo<Authority> findAllAuthority(int pageNum, int pageSize,int id) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Authority> authorityPage = authorityMapper.findAllAuthority(id);
        PageInfo<Authority> pageInfo =  new PageInfo<>(authorityPage);
        return pageInfo;
    }
}
