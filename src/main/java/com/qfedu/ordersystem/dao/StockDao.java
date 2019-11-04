package com.qfedu.ordersystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.MenuStock;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface StockDao extends BaseMapper<MenuStock> {

    @Select ("SELECT stock FROM menu_stock WHERE mid = #{mid}")
    int selectStockByMid(Integer mid);

}
