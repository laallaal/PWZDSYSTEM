package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("hotpot")
public class Hotpot {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String hotpotName;

    private Float money;

    private String imgUrl;


}