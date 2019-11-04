package com.qfedu.ordersystem.entry;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ttable")
public class Tables {

    @TableId(type = IdType.AUTO)
    private int id;
    private String tname;
    private String stateid;
    private String tfrom;
    private String image;
    private int rid;
}
