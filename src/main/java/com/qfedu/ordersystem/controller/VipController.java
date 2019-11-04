package com.qfedu.ordersystem.controller;


import com.qfedu.ordersystem.entry.User;
import com.qfedu.ordersystem.service.VipService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "VIP管理系统", tags = "VIP用户")
public class VipController {
    @Autowired
    VipService vipService;

    @PostMapping("add")
    @ApiOperation(value = "VIP管理系统", notes = "添加VIP用户")
    public void addVipUser(User user) {
        if (user.getMoney() > 10000 && user.getMoney() < 30000) {
            user.setLevel(1);
            vipService.addVipUser(user);
        }
        if (user.getMoney() > 30000 && user.getMoney() < 50000) {
            user.setLevel(2);
            vipService.addVipUser(user);
        }
        if (user.getMoney() > 5) {
            user.setLevel(3);
            vipService.addVipUser(user);
        }
    }

    @PostMapping("/login")
    @ApiOperation(value = "VIP管理系统", notes = "登录")
    public void login(User user) {
        boolean islogin = vipService.login(user);
    }

    @PostMapping("/selectmoney")
    @ApiOperation(value = "VIP管理系统", notes = "账户余额查询")
    public String vipBalance(String vname) {
        return vipService.selectBalance(vname);
    }
}
