package com.ping.security.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ping.security.dto.MenuRole;
import com.ping.security.mapper.MenuRoleMapper;
import com.ping.security.service.MenuRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Description:菜单-角色实现类
* @Author: pzq
* @Date:
* @throw:
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements MenuRoleService {

}
