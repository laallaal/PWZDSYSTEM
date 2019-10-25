package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer tid;

    private Integer hid;
    private double sumPrice;
    private int pungecydegree;

    private Integer state;
    private String orderNum;

}