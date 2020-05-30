package com.keji.controller;

import com.github.pagehelper.PageInfo;
import com.keji.common.web.BaseController;
import com.keji.pojo.Authority;
import com.keji.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorityController extends BaseController {

    @Autowired
    private AuthorityService authorityService;

    /**
     * 查询锁有的权限
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAllAuthority")
    public  String  findAllAuthority(Integer pageNum,Integer pageSize,Integer id){
        PageInfo<Authority> authorityPageInfo = authorityService.findAllAuthority(pageNum,pageSize,id);
        return dealQueryResult(authorityPageInfo,authorityPageInfo);
    }
}
