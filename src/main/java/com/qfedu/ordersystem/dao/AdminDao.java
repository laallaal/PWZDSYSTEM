package com.qfedu.ordersystem.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.Tables;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface AdminDao extends BaseMapper<Admin> {


    @Select("select * from ttable")
    List<Tables> selectAllTables();


    @Select("select * from ttable where tfrom = #{tfrom}")
    List<Tables> selectTablesByTypeId(String tfrom);


    @Select("select * from ttable where tname like CONCAT(#{str},'%') ")
    List<Tables> selectTableByInput(String str);
}
