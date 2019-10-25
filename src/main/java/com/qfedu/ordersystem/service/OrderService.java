package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.Order;
import com.qfedu.ordersystem.entry.OrderMenu;
import com.qfedu.ordersystem.vo.R;

import java.util.List;

public interface OrderService extends IService<Order> {

    R createOrder(Order order);



    R selectOrderMenuByTid(int tid);

}
