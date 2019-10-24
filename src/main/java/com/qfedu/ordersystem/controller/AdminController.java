package com.qfedu.ordersystem.controller;


import com.qfedu.ordersystem.service.AdminService;
import com.qfedu.ordersystem.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping
    public R selectAllTables() {

        return R.getOk(adminService.selectAllTables());
    }




}
