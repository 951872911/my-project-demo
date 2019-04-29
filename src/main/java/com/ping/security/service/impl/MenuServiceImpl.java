package com.ping.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ping.security.dto.Menu;
import com.ping.security.dto.MenuRole;
import com.ping.security.dto.Role;
import com.ping.security.mapper.MenuMapper;
import com.ping.security.service.MenuRoleService;
import com.ping.security.service.MenuService;
import com.ping.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
* @Description:菜单实现类
* @Author: pzq
* @Date:
* @throw:
*/
@Service
@Transactional(rollbackFor = Exception.class)
@CacheConfig(cacheNames = "menus_cache")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService{

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleService menuRoleService;

    @Autowired
    RoleService roleService;

    @Cacheable(key = "#root.methodName")
    @Override
    public List<Menu> getAllMenu() {
        List<Menu> menuList = list();
        for (Menu menu : menuList) {
            Long id = menu.getId();
            List<MenuRole> menuRoleList = menuRoleService.list(new QueryWrapper<MenuRole>().eq("mid", id));
            List<Long> rIdList = new ArrayList<>();
            for (MenuRole menuRole: menuRoleList) {
                Long rId = menuRole.getRid();
                rIdList.add(rId);
            }
            List<Role> roles = new ArrayList<>();
            if (!CollectionUtils.isEmpty(rIdList)) {
                roles = (List<Role>) roleService.listByIds(rIdList);
            }
            menu.setRoles(roles);
        }
        return menuList;
    }
}
