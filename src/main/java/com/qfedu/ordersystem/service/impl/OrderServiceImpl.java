package com.qfedu.ordersystem.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.OrderDao;
import com.qfedu.ordersystem.dao.OrderMenuDao;
import com.qfedu.ordersystem.entry.Menu;
import com.qfedu.ordersystem.entry.Order;
import com.qfedu.ordersystem.entry.OrderMenu;
import com.qfedu.ordersystem.service.OrderService;
import com.qfedu.ordersystem.utils.jedis.JedisClient;
import com.qfedu.ordersystem.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Autowired
    JedisClient jedisClient;
    @Autowired
    OrderMenuDao orderMenuDao;

    @Override
    public R createOrder(Order order) {
        order.setOrderNum(UUID.randomUUID().toString());
        int oid = getBaseMapper().insertSelective(order);
        jedisClient.set("位置" + order.getTid(),oid + "");
        return R.getOk(oid);
    }

    @Override
    public R selectOrderMenuByTid(int tid) {
        int  oid = Integer.parseInt(jedisClient.get("位置" + tid));
        List<OrderMenu> orderMenuList= orderMenuDao.selectOrderMenuByTid(oid);
        return R.getOk(orderMenuList);
    }

    @Override

}
