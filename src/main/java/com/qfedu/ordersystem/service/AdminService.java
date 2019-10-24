package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.Admin;
import com.qfedu.ordersystem.entry.Tables;

import java.util.List;

public interface AdminService extends IService<Admin> {

    List<Tables> selectAllTables();
}
