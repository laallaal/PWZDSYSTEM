package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: Administrator
 * @date: 2019/11/4 10:34
 * @version: 1.0
 * @description:
 */


@Data
@TableName("appoint")
public class Appoint {

    @TableId(type = IdType.AUTO)
    private int id;
    private String pname;
    private String tname;
    private int pnum;
    private Date atime;
    private int rid;



}
