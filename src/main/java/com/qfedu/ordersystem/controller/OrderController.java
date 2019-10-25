package com.qfedu.ordersystem.controller;

import java.util.List;

import com.qfedu.ordersystem.entry.Order;
import com.qfedu.ordersystem.entry.OrderMenu;
import com.qfedu.ordersystem.service.OrderService;
import com.qfedu.ordersystem.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("api/order/createOrder")
    public R addOrder(Order order){
        return orderService.createOrder(order);
    }

    @RequestMapping("api/order/selectOrderMenu")
    public R selectOrderMenu(int tid) {
        return orderService.selectOrderMenuByTid(tid);
    }

    @RequestMapping("api/Order/orderAll")
    public R orderAll(){
        return R.getOk(orderService.list());
    }
    @RequestMapping("api/order/addOrderMenu")
    public R addOrderMenu() {

    }

}
