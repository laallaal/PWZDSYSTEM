package com.qfedu.ordersystem.controller;

import java.util.List;

import com.qfedu.ordersystem.entry.Order;
import com.qfedu.ordersystem.entry.OrderMenu;
import com.qfedu.ordersystem.service.OrderMenuService;
import com.qfedu.ordersystem.service.OrderService;
import com.qfedu.ordersystem.vo.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "订单系统",tags = "订单系统")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderMenuService orderMenuService;

    @PostMapping("api/order/createOrder")
    @ApiOperation(value = "点击座位，创建相应订单",notes = "点击座位，创建相应订单")
    public R addOrder(Integer tid){
        return orderService.createOrder(tid);
    }

    @GetMapping("api/order/selectOrderMenu")
    @ApiOperation(value = "根据座位号查找当前正在就餐人员的菜单", notes = "根据座位号查找当前正在就餐人员的菜单")
    public R selectOrderMenu(Integer tid) {
        return orderService.selectOrderMenuByTid(tid);
    }

    @GetMapping("api/Order/selectOrderAllByState")
    @ApiOperation(value = "按状态查询所有的订单，不输入值查询所有，1未下单，2已下单，3已支付", notes = "按状态查询所有的订单，不输入值查询所有，1未下单，2已下单，3已支付")
    public R orderAll(Integer state){
        return orderService.selectOrderAllByState(state);
    }

    @PutMapping("api/order/updataOrderMenuNum")
    @ApiOperation(value = "根据座位号，改变单个菜品的数量，若是无该菜品，添加菜品，有该菜品，num为1为加一，-1为减一",
    notes = "根据座位号，改变单个菜品的数量，若是无该菜品，添加菜品，有该菜品，num为1为加一，-1为减一")
    public R updataOrderMenuNum(Integer tid,Integer num, Integer mid) {
        return orderMenuService.updataOrderMenuNum(tid,num,mid);
    }

    @PutMapping("api/order/placeAnOrder")
    @ApiOperation(value = "根据座位号确定下单，并计算价格",notes = "确定下单，并计算价格")
    public R placeAnOrder(Integer tid) {
        return orderService.placeAnOrder(tid);
    }

    @PutMapping("api/order/choosePungecydegree")
    @ApiOperation(value = "选择辣度", notes = "选择辣度")
    public R choosePungecydegree(Integer tid,Integer pungecydegree) {
        return orderService.choosePungecydegree(tid,pungecydegree);
    }

    @DeleteMapping("api/order/deleteOrder")
    @ApiOperation(value = "按订单id删除订单", notes = "按订单id删除订单")
    public R deleteOrder(Integer oid) {
        return orderService.deleteOrder(oid);

    }
    @PutMapping("/api/order/paySuccess")
    @ApiOperation(value = "支付成功",notes = "支付成功")
    public R paySuccess(  Integer oid) {
        return orderService.paySuccess(oid);

    }


    @DeleteMapping("/api/order/deleteOrderMenuByTid")
    @ApiOperation(value = "删除对应客户的所有菜品",notes = "删除对应客户的所有菜品")
    public R deleteOrderMenuByTid(Integer tid) {
        if (tid == null) {
            return R.setERROR();
        }
        return orderService.deleteOrderMenuByTid(tid);

    }

    @DeleteMapping("/api/order/deleteOrderMenuByTidAndMid")
    @ApiOperation(value = "删除对应客户的单个菜品",notes = "删除对应客户的单个菜品")
    public R deleteOrderMenuByTid(Integer tid, Integer mid) {
        if (tid == null || mid ==null) {
            return R.setERROR();
        }
        return orderService.deleteOrderMenuByTidAndMid(tid,mid);

    }
}
