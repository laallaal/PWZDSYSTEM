package com.qfedu.ordersystem.controller;

import com.qfedu.ordersystem.entry.Appoint;
import com.qfedu.ordersystem.service.AdminService;
import com.qfedu.ordersystem.service.StockService;
import com.qfedu.ordersystem.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @Autowired
    StockService stockService;

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



    @GetMapping(value = "/admin/queryAllDrinks")
    public R queryAllDrinks() {
        return R.setResult (true, adminService.queryAllDrinks ());
    }

    @PostMapping(value = "/admin/addDrinks")
    @ApiOperation(value = "addDrinks", notes = "添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜品id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "tid", value = "桌子id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "num", value = "所选酒水数量", required = true, dataType = "Integer")
    })
    public R addDrinks(Integer tid, Integer uid, Integer id, Integer num) {
        int stock = stockService.selectByMid(id);
        if (stock <= 0) {
            return R.setResult (false, "库存不足");
        } else {
            return R.setResult (true, adminService.addDrinks (tid, uid, id, num));
        }
    }

    @GetMapping(value = "/selectRestaurant")
    @ApiOperation(value = "selectRestaurant", notes = "根据酒店id查询酒店详情")
    public R restaurantDetail(Integer id){
        return R.setResult (true,adminService.selectRestaurant (id));
    }

    @GetMapping(value = "/admin/selectAdmin")
    @ApiOperation(value = "selectAdmin", notes = "查询员工详情")
    public R selectAdmin(Integer id){
        return R.setResult (true,adminService.getById(id));
    }

    @GetMapping(value = "/admin/login")
    public R login (String username,String password ){
        return R.setResult (adminService.login(username,password),"登录成功");
    }


}
