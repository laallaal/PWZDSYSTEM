package com.qfedu.ordersystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.Menu;
import com.qfedu.ordersystem.entry.Order;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;


public interface OrderDao extends BaseMapper<Order> {

    Integer insertSelective(Order order);

    int updateByPrimaryKey(Order order);

    List<Order> selectOrderAllByState(Integer state);

    Integer deleteOrder(int oid);

    Integer updateStateById(Integer oid);
}
