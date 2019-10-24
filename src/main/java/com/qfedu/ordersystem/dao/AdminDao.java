package com.qfedu.ordersystem.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.Admin;
import com.qfedu.ordersystem.entry.Tables;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminDao extends BaseMapper<Admin> {

    @Select("select * from tables")
    List<Tables> selectAllTables();

}
