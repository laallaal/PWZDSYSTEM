package com.qfedu.ordersystem.entry;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("guodi")
public class GuoDi {

    @TableId
    private int id;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private int tableId;
    private int horderId;
    private int imgId;
    private String img;
}
