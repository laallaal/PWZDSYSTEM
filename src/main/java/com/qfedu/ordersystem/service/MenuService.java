package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.Menu;
import com.qfedu.ordersystem.vo.R;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface MenuService extends IService<Menu> {

    R selectMenuByType(Menu menu , Integer pageNum);

    R selectFoodByName(String fname);
}
