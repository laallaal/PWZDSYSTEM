package com.qfedu.ordersystem.entry;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("menu")
public class Menu {
    private int id;
    private String fname;
    private double money;
    private int parent;
    private int level;
    private String imgUrl;
    private int residue;
}
