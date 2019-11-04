package com.qfedu.ordersystem.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.OrderDao;
import com.qfedu.ordersystem.dao.OrderMenuDao;
import com.qfedu.ordersystem.entry.Order;
import com.qfedu.ordersystem.entry.OrderMenu;
import com.qfedu.ordersystem.service.OrderService;

import com.qfedu.ordersystem.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    OrderMenuDao orderMenuDao;

    @Override
    public R createOrder(Integer tid) {

        Order order = new Order();
        order.setOrderNum(UUID.randomUUID().toString());
        order.setTid(tid);
        order.setState(1);
        int oid = getBaseMapper().insertSelective(order);
        redisTemplate.opsForValue().set("位置:" + order.getTid(),order.getId() + "");
        return R.getOK(oid);
    }

    @Override
    public R selectOrderMenuByTid(int tid) {
        String s = redisTemplate.opsForValue().get("位置:" + tid);
        if (s == null || s.equals("")) {
            return R.setERROR();
        }
        Integer oid = Integer.parseInt(s);
        List<OrderMenu> orderMenuList= orderMenuDao.selectOrderMenuByTid(oid);
        return R.getOK(orderMenuList);
    }

    @Override
    public R placeAnOrder(Integer tid) {
        String s = redisTemplate.opsForValue().get("位置:" + tid);
        if (s == null || s.equals("")) {
            return R.setERROR();
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
            redisTemplate.delete("位置:" + tid);
            return R.getOK("ok");
        }else {
            return R.setERROR();
        }
    }

    @Override
    public R choosePungecydegree(Integer tid, Integer pungecydegree) {
        String s = redisTemplate.opsForValue().get("位置:" + tid);
        if (s == null || s.equals("")) {
            return R.setERROR();
        }

        Integer oid = Integer.parseInt(s);
        Order order = new Order();
        order.setId(oid);
        order.setPungecydegree(pungecydegree);
        int rows = getBaseMapper().updateByPrimaryKey(order);
        if (rows > 0){
            return R.getOK("ok");
        }else {
            return R.setERROR();
        }
    }

    @Override
    public R selectOrderAllByState(Integer state) {
        List<Order> orderlist = getBaseMapper().selectOrderAllByState(state);
        return R.getOK(orderlist);
    }

    @Override
    public R deleteOrder(Integer oid) {
        Integer row = getBaseMapper().deleteOrder(oid);
        Integer count = orderMenuDao.deleteByOid(oid);
        if (row > 0){
            return R.getOK("ok");
        }else {
            return R.setERROR();
        }
    }

    @Override
    public R paySuccess(Integer oid) {
        Integer row = getBaseMapper().updateStateById(oid);
        if (row > 0){
            return R.getOK("ok");
        }else {
            return R.setERROR();
        }
    }


}
