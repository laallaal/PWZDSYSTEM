package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.OrderMenu;
import com.qfedu.ordersystem.vo.R;

public interface OrderMenuService extends IService<OrderMenu> {


    R updataOrderMenuNum(int tid, int num,Integer mid);
}
