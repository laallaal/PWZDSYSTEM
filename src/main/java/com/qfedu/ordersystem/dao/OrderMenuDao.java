package com.qfedu.ordersystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.OrderMenu;
import java.util.List;

public interface OrderMenuDao extends BaseMapper<OrderMenuDao> {
    List<OrderMenu> selectOrderMenuByTid(int oid);

}
