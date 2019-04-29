package com.ping.security.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ping.security.dto.Role;
import com.ping.security.mapper.RoleMapper;

import com.ping.security.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Description:角色实现类
* @Author: pzq
* @Date:
* @throw:
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
