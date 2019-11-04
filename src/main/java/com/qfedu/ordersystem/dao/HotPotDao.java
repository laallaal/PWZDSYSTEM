package com.qfedu.ordersystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.GuoDi;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface HotPotDao extends BaseMapper<GuoDi> {

    @Select("select * from guodi")
    GuoDi selectGuoDi();


    @Update("update guodi set img1 = #{img} where id = #{id}")
    void changeimg1(int id, String img);


    @Update("update guodi set img2 = #{img} where id = #{id}")
    void changeimg2(int id, String img);


    @Update("update guodi set img3 = #{img} where id = #{id}")
    void changeimg3(int id, String img);


    @Update("update guodi set img4 = #{img} where id = #{id}")
    void changeimg4(int id, String img);
}
