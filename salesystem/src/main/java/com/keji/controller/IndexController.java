package com.keji.controller;

import com.keji.common.web.BaseController;
import com.keji.pojo.Authority;
import com.keji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/indexMenu")
public class IndexController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 查询该用户对应的菜单
     * @return
     */
    @RequestMapping("/initMenu")
    public String initMenu(){
        List<List<Authority>> result =  userService.finTheUserAllAuth();
        return dealQueryResult(result,result);
    }
}
