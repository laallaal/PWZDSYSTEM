package com.qfedu.ordersystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.OrderMenuDao;
import com.qfedu.ordersystem.entry.OrderMenu;
import com.qfedu.ordersystem.service.OrderMenuService;
import com.qfedu.ordersystem.vo.R;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
@Service
public class OrderMenuServiceImpl extends ServiceImpl<OrderMenuDao, OrderMenu> implements OrderMenuService {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public R updataOrderMenuNum(int tid, int num,Integer mid) {
        String s = redisTemplate.opsForValue().get("位置:" + tid);
        if (s == null || s.equals("")) {
            return R.setERROR();
        }
        Integer oid = Integer.parseInt(s);
        Integer rows = 0;
        OrderMenu orderMenu = new OrderMenu();
        orderMenu.setOid(oid);
        orderMenu.setNum(num);
        orderMenu.setMid(mid);
        Integer count = getBaseMapper().selectByOidAndMid(orderMenu);
        System.out.println(count);
        if (count == 0){
            if (num > 0) {
                Integer i = getBaseMapper().addOrderMenu(orderMenu);
                if (i > 0){
                    return R.getOK("ok");
                } else {
                    return R.setERROR();
                }
            } else {
                return R.setERROR();

            }
        }
        if (num > 0) {
            rows = getBaseMapper().riseOrderMenuNumByOid(orderMenu);
        } else {
            rows = getBaseMapper().decrOrderMenuNumByOid(orderMenu);
        }

        if (rows > 0){

            return R.getOK("ok");
        }else {
            return R.setERROR();
        }
    }
}
