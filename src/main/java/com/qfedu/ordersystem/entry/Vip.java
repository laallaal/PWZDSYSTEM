package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("vip")
public class Vip {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private Integer level;

    private Float balance;

}