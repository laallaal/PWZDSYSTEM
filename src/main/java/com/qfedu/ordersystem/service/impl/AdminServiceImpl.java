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
}
