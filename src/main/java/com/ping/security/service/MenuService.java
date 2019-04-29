package com.ping.security.service;


import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ping.security.dto.Menu;

public interface MenuService extends IService<Menu> {

    List<Menu> getAllMenu();
}
