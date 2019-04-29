package com.ping.security.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ping.security.dto.HrRole;
import com.ping.security.mapper.HrRoleMapper;
import com.ping.security.service.HrRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @Description:用户-角色实现类
* @Author: pzq
* @Date:
* @throw:
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class HrRoleServiceImpl extends ServiceImpl<HrRoleMapper, HrRole> implements HrRoleService {

}
