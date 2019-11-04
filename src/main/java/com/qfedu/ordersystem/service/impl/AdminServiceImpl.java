package com.qfedu.ordersystem.service.impl;


import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.AdminDao;
import com.qfedu.ordersystem.entry.Admin;
import com.qfedu.ordersystem.entry.Tables;
import com.qfedu.ordersystem.service.AdminService;
import com.qfedu.ordersystem.utils.JsonUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Tables> implements AdminService {


    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public List<Tables> selectAllTables() {

        List<Tables> tables = getBaseMapper().selectAllTables();

        System.out.println(tables);

        redisTemplate.opsForValue().set("ALLTABLES", JsonUtils.objectToJson(tables));

        System.out.println(redisTemplate.opsForValue().get("ALLTABLES"));

        System.out.println("222222222222222222222");

        return tables;
    }


    @Override
    public List<Tables> selectTablesByTypeId(String tfrom) {

        List<Tables> tables = getBaseMapper().selectTablesByTypeId(tfrom);

        redisTemplate.opsForValue().set(tfrom, tables.toString());

        return tables;
    }

    @Override
    public List<Tables> selectTableByInput(String str) {


        List<Tables> tables = getBaseMapper().selectTableByInput(str);

        redisTemplate.opsForValue().set(str, tables.toString());

        return tables;
    }
}
