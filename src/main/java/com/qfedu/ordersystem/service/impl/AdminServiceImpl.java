package com.qfedu.ordersystem.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.AdminDao;
import com.qfedu.ordersystem.entry.Tables;
import com.qfedu.ordersystem.service.AdminService;
import com.qfedu.ordersystem.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private  AdminDao adminDao;

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



}
