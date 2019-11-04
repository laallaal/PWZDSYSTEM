package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin")
public class Admin {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer number;
    private String eName;
    private String password;
    private Integer permission;

    public Admin() {
    }

    public Admin(Integer id, Integer number, String eName, Integer permission) {
        this.id = id;
        this.number = number;
        this.eName = eName;
        this.permission = permission;
    }
}
