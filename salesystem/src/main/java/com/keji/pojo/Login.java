package com.keji.pojo;

import lombok.Data;

/**
 * 登陆状态类
 */
@Data
public class Login {
    //是否登陆
    private Boolean online;
    //用户账号
    private String number;
}
