package com.keji.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author dcy
 * @date 2019/9/8 10:25
 * @description
 */
@Data
public class Role implements Serializable {
    private Integer id;//id
    private String roleName;//角色名称
    private String describe;//角色描述
    private Integer status;//角色开启状态
    private Integer deleteStatus;//删除状态
    private Date createDate;//创建日期;
    private Date updateDate;//更新日期；
    private Integer modifierId;//修改人id
    private Integer roleNum;//角色编号
    private List<Authority> authorities;//该角色对应的权限
}
