package com.qfedu.ordersystem.entry;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("menu")
public class Menu {


    private int residue;


    @TableId(type = IdType.AUTO)
    private Integer id;

    private String fName;

    private Float money;

    private Integer parent;

    private Integer level;

    private String imgUrl;
}