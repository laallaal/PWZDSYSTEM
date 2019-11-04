package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.Appoint;
import com.qfedu.ordersystem.entry.Restaurant;
import com.qfedu.ordersystem.entry.Tables;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import java.util.List;

public interface AdminService  {

    List<Tables> selectAllTables();

    List<Tables> selectTablesByTypeId(String tfrom);

    List<Tables> selectTableByInput(String str);

    Restaurant chooseRestaurantByCode(String str);

    void changeTableStateId(int tid, int stateid,int rid);

    List<Appoint> appoint(int rid);

    void addAppoint(Appoint appoint);


    /*Tables intoTable(int tid, int stateid);*/
}
