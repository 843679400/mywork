package com.keji.mapper;

import com.github.pagehelper.Page;
import com.keji.pojo.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dcy
 * @date 2019/9/11 16:56
 * @description
 */
@Mapper
public interface AuthorityMapper {

    /**
     * 查询出所有的权限
     * @return 权限的集合
     */
    Page<Authority> findAllAuthority(@Param("id") Integer id);

    /**
     * 通过id查询权限
     * @return
     */
    Authority findAuthorityById(@Param("id") Integer id);

}
