package com.keji.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author dcy
 * @date 2019/9/10 21:22
 * @description
 */
@Data
public class Authority {
    private Integer id;//权限id
    private String name;//权限名称
    private String describe;//权限描述
    private String path;//权限路径
    private Integer parId;//父权限的id
}
