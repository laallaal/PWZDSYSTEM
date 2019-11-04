package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.MenuStock;

public interface StockService extends IService<MenuStock> {

    int selectByMid(Integer mid);
}
