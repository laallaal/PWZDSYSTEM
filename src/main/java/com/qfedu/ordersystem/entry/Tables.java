package com.qfedu.ordersystem.entry;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName
public class Tables {

    @TableId
    private int id;
    private String tname;
    private String state;
    private String tfrom;
}
