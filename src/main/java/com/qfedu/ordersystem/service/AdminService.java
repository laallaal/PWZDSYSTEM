package com.qfedu.ordersystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.ordersystem.entry.*;
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


    Menu queryAllDrinks();

    int addDrinks(Integer tid,Integer uid,Integer id,Integer num);

    boolean login(String username, String password);

    Restaurant selectRestaurant(Integer id);

    Admin getById(Integer id);
}
