package com.qfedu.ordersystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.OrderMenu;
import java.util.List;

public interface OrderMenuDao extends BaseMapper<OrderMenu> {
    List<OrderMenu> selectOrderMenuByTid(int oid);

    int addOrderMenu(OrderMenu orderMenu);



    Integer riseOrderMenuNumByOid(OrderMenu orderMenu);

    Integer decrOrderMenuNumByOid(OrderMenu orderMenu);

    Integer selectByOidAndMid(OrderMenu orderMenu);

    Integer deleteByOid(Integer oid);

    int deleteOrderMenuByTidAndMid(OrderMenu orderMenu);

}
