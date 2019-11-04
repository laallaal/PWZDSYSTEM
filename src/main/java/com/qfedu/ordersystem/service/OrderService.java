package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.Order;
import com.qfedu.ordersystem.entry.OrderMenu;
import com.qfedu.ordersystem.vo.R;

import java.util.List;

public interface OrderService extends IService<Order> {

    R createOrder(Integer tid);



    R selectOrderMenuByTid(int tid);

    R placeAnOrder(Integer tid);

    R choosePungecydegree(Integer tid, Integer pungecydegree);

    R selectOrderAllByState(Integer state);

    R deleteOrder(Integer oid);

    R paySuccess(Integer oid);



    R deleteOrderMenuByTid(Integer tid);

    R deleteOrderMenuByTidAndMid(Integer tid, Integer mid);
}
