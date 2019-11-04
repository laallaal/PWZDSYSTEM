package com.qfedu.ordersystem.controller;


import com.qfedu.ordersystem.service.AdminService;
import com.qfedu.ordersystem.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
@Api(value = "管理员权限", tags = "这里展示的是管理员才应该进行的操作")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Resource
    private RedisTemplate<String, String>  redisTemplate;

    @GetMapping("/selectAllTables")
    @ApiOperation(value = "展示全部餐桌")
    public R selectAllTables() {

        String alltables = redisTemplate.opsForValue().get("ALLTABLES");

        System.out.println("1111111111111111111111111111111"+alltables);

        if (alltables != null) {

            return R.getOk(alltables);

        }

        return R.getOk(adminService.selectAllTables());

    }

    @PostMapping("/selectTablesByTypeId")
    @ApiOperation(value = "按类别展示餐桌")
    public R selectTablesByTypeId(String tfrom) {

        String tables = redisTemplate.opsForValue().get(tfrom);

        if (tables != null) {

            return R.getOk(tables);
        }

        return R.getOk(adminService.selectTablesByTypeId(tfrom));
    }


    @PostMapping("/selectTableByInput")
    @ApiOperation(value = "搜索查询餐桌")
    public R selectTableByInput(String str) {

        String tables = redisTemplate.opsForValue().get(str);

        if (tables != null) {

            return R.getOk(tables);
        }

        return R.getOk(adminService.selectTableByInput(str));
    }






}
