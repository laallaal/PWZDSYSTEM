package com.qfedu.ordersystem.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.AdminDao;
import com.qfedu.ordersystem.dao.MenuDao;
import com.qfedu.ordersystem.dao.OrderDao;
import com.qfedu.ordersystem.dao.RestaurantDao;
import com.qfedu.ordersystem.entry.*;
import com.qfedu.ordersystem.service.AdminService;
import com.qfedu.ordersystem.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private  AdminDao adminDao;

    @Autowired
    OrderDao orderDao;
    @Autowired
    MenuDao menuDao;
    @Autowired
    RestaurantDao restaurantDao;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public List<Tables> selectAllTables() {

        List<Tables> tables = adminDao.selectAllTables();

        System.out.println(tables);

        redisTemplate.opsForValue().set("ALLTABLES", JsonUtils.objectToJson(tables));

        System.out.println(redisTemplate.opsForValue().get("ALLTABLES"));

        System.out.println("222222222222222222222");

        return tables;
    }


    @Override
    public List<Tables> selectTablesByTypeId(String tfrom) {

        List<Tables> tables = adminDao.selectTablesByTypeId(tfrom);

        redisTemplate.opsForValue().set(tfrom, tables.toString());

        return tables;
    }

    @Override
    public List<Tables> selectTableByInput(String str) {


        List<Tables> tables = adminDao.selectTableByInput(str);

        redisTemplate.opsForValue().set(str, tables.toString());

        return tables;
    }

    @Override
    public Restaurant chooseRestaurantByCode(String str) {


        return adminDao.selectRestaurantByCode(str);
    }

    @Override
    public void changeTableStateId(int tid, int stateid,int rid) {

        adminDao.changeTableStateId(tid, stateid,rid);
    }

    @Override
    public List<Appoint> appoint(int rid) {
        List<Appoint> appoints = adminDao.selectAppointByCode(rid);

        System.out.println(appoints);
        return appoints ;
    }

    @Override
    public void addAppoint(Appoint appoint) {

        adminDao.addAppoint(appoint);
    }



    @Override
    public Menu queryAllDrinks() {
        return menuDao.queryAllDrinks();
    }

    @Override
    public int addDrinks(Integer tid, Integer uid, Integer id, Integer num) {
        Map<String, Object> map = new HashMap<>();
        map.put ("tid", tid);
        map.put ("uid", uid);
        map.put ("mid", id);
        map.put ("num", num);
        map.put ("result", 0);
        orderDao.createOrderAndStock(map);
        return (int) map.get ("result");
    }



    @Override
    public Restaurant selectRestaurant(Integer id) {
        return restaurantDao.selectById (id);
    }

    @Override
    public Admin getById(Integer id) {


        return adminDao.getById(id);
    }

    @Override
    public boolean login(String username, String password) {
        return adminDao.login(username,password);
    }

}
