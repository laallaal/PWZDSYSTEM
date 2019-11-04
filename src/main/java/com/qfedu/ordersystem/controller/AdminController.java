package com.qfedu.ordersystem.controller;

import com.qfedu.ordersystem.entry.Appoint;
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
@Api(value = "管理员权限", tags = "店员操作")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Resource
    private RedisTemplate<String, String>  redisTemplate;

    @GetMapping("/selectAllTables")
    @ApiOperation(value = "展示全部餐桌")
    public R selectAllTables() {

        return R.getOK(adminService.selectAllTables());
    }

    @PostMapping("/selectTablesByTypeId")
    @ApiOperation(value = "按类别展示餐桌")
    public R selectTablesByTypeId(String tfrom) {

        String tables = redisTemplate.opsForValue().get(tfrom);

        if (tables != null) {

            return R.getOK(tables);
        }

        return R.getOK(adminService.selectTablesByTypeId(tfrom));
    }


    @PostMapping("/selectTableByInput")
    @ApiOperation(value = "搜索查询餐桌")
    public R selectTableByInput(String str) {

        String tables = redisTemplate.opsForValue().get(str);

        if (tables != null) {

            return R.getOK(tables);
        }

        return R.getOK(adminService.selectTableByInput(str));
    }

    @PostMapping("/addAppoint")
    @ApiOperation(value = "添加预约")
    public void addAppoint(Appoint appoint) {

        adminService.addAppoint(appoint);

    }


    @PostMapping("/appoint")
    @ApiOperation(value = "展示该餐厅预约信息")
    public R appoint(int rid) {

        return  R.getOK(adminService.appoint(rid));

    }



    @PostMapping("/changeTableType")
    @ApiOperation(value = "改变餐桌状态")
    public void changeTableType(int tid, int stateid,int rid) {

        adminService.changeTableStateId(tid, stateid, rid);

    }



    @PostMapping("/chooseRestaurant")
    @ApiOperation(value = "选择餐厅")
    public R chooseRestaurant(String str) {

        return R.getOK(adminService.chooseRestaurantByCode(str));

    }




}
