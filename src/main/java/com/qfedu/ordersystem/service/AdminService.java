package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.Tables;

import java.util.List;

public interface AdminService extends IService<Tables> {

    List<Tables> selectAllTables();

    List<Tables> selectTablesByTypeId(String tfrom);

    List<Tables> selectTableByInput(String str);
}
