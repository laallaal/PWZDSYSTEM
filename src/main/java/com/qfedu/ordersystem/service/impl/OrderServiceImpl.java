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

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Autowired
    JedisClient jedisClient;
    @Autowired
    OrderMenuDao orderMenuDao;

    @Override
    public R createOrder(Integer tid) {
        Order order = new Order();
        order.setOrderNum(UUID.randomUUID().toString());
        order.setTid(tid);
        order.setState(1);
        int oid = getBaseMapper().insertSelective(order);
        jedisClient.set("位置:" + order.getTid(),order.getId() + "");
        return R.getOk(oid);
    }

    @Override
    public R selectOrderMenuByTid(int tid) {
        String s = jedisClient.get("位置:" + tid);
        if (s == null || s.equals("")) {
            return R.setError();
        }
        Integer oid = Integer.parseInt(s);
        List<OrderMenu> orderMenuList= orderMenuDao.selectOrderMenuByTid(oid);
        return R.getOk(orderMenuList);
    }

    @Override
    public R placeAnOrder(Integer tid) {
        String s = jedisClient.get("位置:" + tid);
        if (s == null || s.equals("")) {
            return R.setError();
        }
        Integer oid = Integer.parseInt(s);
        double sumPrice = 0;
        List<OrderMenu> orderMenuList = orderMenuDao.selectOrderMenuByTid(oid);

        for (int i = 0; i < orderMenuList.size(); i++) {
            sumPrice = sumPrice + (orderMenuList.get(i).getMenu().getMoney() * orderMenuList.get(i).getNum());
        }
        System.out.println(sumPrice);
        Order order = new Order();
        order.setId(oid);
        order.setSumPrice(sumPrice);
        order.setState(2);
        int rows = getBaseMapper().updateByPrimaryKey(order);
        if (rows > 0){
            jedisClient.del("位置:" + tid);
            return R.getOk("ok");
        }else {
            return R.setError();
        }
    }

    @Override
    public R choosePungecydegree(Integer tid, Integer pungecydegree) {
        String s = jedisClient.get("位置:" + tid);
        if (s == null || s.equals("")) {
            return R.setError();
        }

        Integer oid = Integer.parseInt(s);
        Order order = new Order();
        order.setId(oid);
        order.setPungecydegree(pungecydegree);
        int rows = getBaseMapper().updateByPrimaryKey(order);
        if (rows > 0){
            return R.getOk("ok");
        }else {
            return R.setError();
        }
    }

    @Override
    public R selectOrderAllByState(Integer state) {
        List<Order> orderlist = getBaseMapper().selectOrderAllByState(state);
        return R.getOk(orderlist);
    }

    @Override
    public R deleteOrder(Integer oid) {
        Integer row = getBaseMapper().deleteOrder(oid);
        Integer count = orderMenuDao.deleteByOid(oid);
        if (row > 0){
            return R.getOk("ok");
        }else {
            return R.setError();
        }
    }

    @Override
    public R paySuccess(Integer oid) {
        Integer row = getBaseMapper().updateStateById(oid);
        if (row > 0){
            return R.getOk("ok");
        }else {
            return R.setError();
        }
    }


}
