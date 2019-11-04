package com.qfedu.ordersystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface VipDao extends BaseMapper<User> {
    @Insert("INSERT INTO user(vnme,vpassword,money) values (#{vname},#{vpassword},#{money})")
    @ResultType(User.class)
    int addVipUser(User user);

    @Select("select money from user where vname = #{vname}")
    @ResultType(User.class)
    String selectmoney(String vname);

    @Select("select * from user where vname = #{vname} and vpassword = #{vpassword}")
    int selectUser(User user);

}
