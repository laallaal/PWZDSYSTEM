package com.qfedu.ordersystem.controller;


import com.qfedu.ordersystem.service.HotPotService;
import com.qfedu.ordersystem.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "火锅",tags = "火锅")
@RequestMapping("/hotpot")
public class HotPotController {

    @Autowired
    private HotPotService hotPotService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("/selectGuoDi")
    @ApiOperation(value = "",notes = "展示锅底")
    public R selectGuoDi() {

        return R.getOk(hotPotService.selectGuoDi());

    }


    @PostMapping("changeGuoDi")
    @ApiOperation(value = "选锅底", notes = "选锅底" )
    public R changeGuoDi(int id, int imgId, String img) {

        hotPotService.changeGuoDi(id, imgId, img);

        return R.getOk("success");
    }





}
