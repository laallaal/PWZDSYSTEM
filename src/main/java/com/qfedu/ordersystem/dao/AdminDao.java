package com.qfedu.ordersystem.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.Admin;
import com.qfedu.ordersystem.entry.Appoint;
import com.qfedu.ordersystem.entry.Restaurant;
import com.qfedu.ordersystem.entry.Tables;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import static java.time.LocalDate.now;


public interface AdminDao extends BaseMapper<Admin> {


    @Select("select * from ttable t ,img i where t.stateid = i.stateid")
    List<Tables> selectAllTables();


    @Select("select * from ttable t ,img i where tfrom = #{tfrom} and t.stateid = i.stateid")
    List<Tables> selectTablesByTypeId(String tfrom);


    @Select("select * from ttable t ,img i  where t.stateid = i.stateid and tname like CONCAT(#{str},'%') ")
    List<Tables> selectTableByInput(String str);


    @Select("select * from restaurant  where rcode = #{str} ")
    Restaurant selectRestaurantByCode(String str);



    @Update("update ttable t set t.stateid = #{stateid} where t.id = #{tid} and t.rid = #{rid}")
    void changeTableStateId(int tid, int stateid,int rid);



    @Select("select * from appoint a where  a.rid = #{rid} ")
    List<Appoint> selectAppointByCode(int rid);


    @Insert("insert into appoint(tname,pname,pnum,rid,atime) values(#{tname},#{pname},#{pnum},#{rid},now())")
    void addAppoint(Appoint appoint);


    @Select ("SELECT COUNT(*) FROM admin where e_name = #{username} AND `password` = #{password};")
    boolean login(String username, String password);


    @Select("select * from admin where id = #{id}")
    Admin getById(Integer id);
}
