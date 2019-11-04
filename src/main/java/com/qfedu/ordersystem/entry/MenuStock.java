package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("menu_stock")
public class MenuStock {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer mid;
    private Integer stock;

    public MenuStock() {
    }

    public MenuStock(Integer id, Integer mid, Integer stock) {
        this.id = id;
        this.mid = mid;
        this.stock = stock;
    }
}
