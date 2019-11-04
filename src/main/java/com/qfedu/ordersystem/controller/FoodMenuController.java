package com.qfedu.ordersystem.controller;




import com.qfedu.ordersystem.entry.Menu;
import com.qfedu.ordersystem.service.MenuService;
import com.qfedu.ordersystem.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "菜单查询操作" ,tags = "两级菜单")
/**
 * 二级菜单展示，需要获取level和parent
 */
public class FoodMenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/queryMenu")
    public R querySecondMenu(Menu menu, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
/*
        List<Menu> list = (List<Menu>) menuService.selectMenuByType(menu);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(list);
        model.addAttribute("pageInfo", pageInfo);*/
        return menuService.selectMenuByType(menu,pageNum);
    }
    @PostMapping("/selectfood")
    public R selectfood(String fname){
        return menuService.selectFoodByName(fname);
    }
}
