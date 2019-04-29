package com.ping.security.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
* @Description: 角色
* @Param: 
* @return: 
* @Author: pzq
* @Date: 
* @throw: 
*/ 
@Setter
@Getter
@TableName("role")
public class Role implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String nameZh;

}