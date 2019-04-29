package com.ping.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ping.security.dto.Hr;
import com.ping.security.dto.HrRole;
import com.ping.security.dto.Role;
import com.ping.security.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
* @Description: 查询用户的service
* @Param:
* @return:
* @Author: pzq
* @Date:
* @throw:
*/
@Service
public class HrService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private HrMapper hrMapper;

    @Autowired
    private HrRoleService hrRoleService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr  = hrMapper.selectOne(new QueryWrapper<Hr>().eq("username", s));
        if (Objects.isNull(hr)) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        Long hrId = hr.getId();
        List<HrRole> hrRoles = hrRoleService.list(new QueryWrapper<HrRole>().eq("hrid", hrId));
        List<Role> roles = new ArrayList<>();
        for (HrRole hrRole : hrRoles) {
            Long rid = hrRole.getRid();
            Role role = roleService.getById(rid);
            roles.add(role);
        }
        hr.setRoles(roles);
        return hr;
    }
}
