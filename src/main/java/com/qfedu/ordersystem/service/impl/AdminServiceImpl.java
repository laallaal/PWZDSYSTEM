package com.qfedu.ordersystem.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.ordersystem.dao.AdminDao;
import com.qfedu.ordersystem.entry.Admin;
import com.qfedu.ordersystem.entry.Tables;
import com.qfedu.ordersystem.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {


    @Override
    public List<Tables> selectAllTables() {

        List<Tables> tables = getBaseMapper().selectAllTables();


        return tables;
    }


    @Override
    public List<Tables> selectTablesByTypeId(String tfrom) {

        List<Tables> tables = getBaseMapper().selectTablesByTypeId(tfrom);

        return tables;
    }

    @Override
    public List<Tables> selectTableByInput(String str) {

        System.out.println("111111111111");
        List<Tables> tables = getBaseMapper().selectTableByInput(str);

        System.out.println("2222222");

        return tables;
    }
}
