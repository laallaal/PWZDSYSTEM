package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: Administrator
 * @date: 2019/11/4 9:46
 * @version: 1.0
 * @description:
 */
@Data
@TableName("restaurant")
public class Restaurant {


    @TableId(type = IdType.AUTO)
    private int id;
    private String rcode;
    private String rname;

}
