package com.qfedu.ordersystem.service.impl;

import com.qfedu.ordersystem.dao.VipDao;
import com.qfedu.ordersystem.entry.User;
import com.qfedu.ordersystem.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VipServiceImpl implements VipService {

    @Autowired
    VipDao vipDao;
    @Override
    public String addVipUser(User user) {
        int count  = vipDao.addVipUser(user);

        if (count>1){
            return "success";
        }else {

            return "fail";
        }
    }

    @Override
    public String selectBalance(String vname) {
        String money = vipDao.selectmoney(vname);
        return money;
    }

    @Override
    public boolean login(User user) {
        int count = vipDao.selectUser(user);
        if (count>1 ){
            return true;
        }else {
            return false;
        }
    }
}
