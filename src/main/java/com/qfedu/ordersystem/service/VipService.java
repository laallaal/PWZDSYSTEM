package com.qfedu.ordersystem.service;

import com.qfedu.ordersystem.entry.User;

public interface VipService {
    String addVipUser(User user);


    String selectBalance(String vname);

    boolean login(User user);
}
