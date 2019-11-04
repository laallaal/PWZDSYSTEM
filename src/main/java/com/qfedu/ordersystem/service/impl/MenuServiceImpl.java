package com.qfedu.ordersystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.qfedu.ordersystem.dao.MenuDao;
import com.qfedu.ordersystem.entry.Menu;
import com.qfedu.ordersystem.service.MenuService;
import com.qfedu.ordersystem.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao,Menu> implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public R selectMenuByType(Menu menu, Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Menu> list = menuDao.selectAllByType(menu);
        /*PageInfo<Menu> pageInfo = new PageInfo<Menu>(list);*/
        return R.getOK(list);
    }

    @Override
    public R selectFoodByName(String fname) {

        List<Menu> list = menuDao.selectFood(fname);
        return R.getOK(list);
    }

}
