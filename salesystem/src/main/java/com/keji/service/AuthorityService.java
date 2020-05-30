package com.keji.service;

import com.github.pagehelper.PageInfo;
import com.keji.pojo.Authority;

import java.util.List;
import java.util.Map;

/**
 * 权限服务层
 * dcy
 */
public interface AuthorityService {

    /**
     * 查询出模块对应的权限
     * @return 权限的集合
     */
    PageInfo<Authority> findAllAuthority(int pageNum, int pageSize,int id);

}
