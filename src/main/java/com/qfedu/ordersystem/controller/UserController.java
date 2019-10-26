package com.qfedu.ordersystem.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Api(value = "user", tags = "这是用户可以操作的功能")
public class UserController {


    @PostMapping("/lalalal")
    @ApiOperation(value = "aaa", notes = "sss", tags = "dddd")
    public void lalala() {

        System.out.println("ssssssssssssssssss");

    }


    @PostMapping("/all")
    @ApiOperation(value = "aaa", notes = "sss", tags = "dddd")
    public void all() {


    }

}
