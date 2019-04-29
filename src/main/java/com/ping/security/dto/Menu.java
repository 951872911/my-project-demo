package com.ping.security.dto;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
* @Description: 菜单DTO
* @Author: pzq
* @Date:
*/
@Data
@TableName("menu")
public class Menu implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private String keepAlive;

    private String requireAuth;

    private Long parentId;

    private String enabled;

    @TableField(exist = false)
    private List<Role> roles;
}
