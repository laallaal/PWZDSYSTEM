package com.qfedu.ordersystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.Menu;
import com.qfedu.ordersystem.entry.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface OrderDao extends BaseMapper<Order> {

    Integer insertSelective(Order order);

    int updateByPrimaryKey(Order order);

    List<Order> selectOrderAllByState(Integer state);

    Integer deleteOrder(int oid);

    Integer updateStateById(Integer oid);



    void createOrderAndStock(Map<String, Object> map);

    @Select ("SELECT * FROM orderfood.order WHERE order_num = #{orderNum} ")
    Order selectByNumber(String orderNum);

    @Update("UPDATE orderfood.order SET state = 1 WHERE order_num = #{orderNum}")
    int payment(String orderNum);

}
