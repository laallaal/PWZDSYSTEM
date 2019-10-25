package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.*;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_menu")
public class OrderMenu {
    @TableId(type = IdType.AUTO)
    private int id;
    private int oid;
    private int mid;
    private int num;
    public List<Menu> menuList;

}
