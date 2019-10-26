package com.qfedu.ordersystem.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


public class UserController {


    @PostMapping("/lalalal")
    @ApiOperation(value = "aaa", notes = "sss", tags = "dddd")
    public void lalala() {

        System.out.println("ssssssssssssssssss");

    }



}
