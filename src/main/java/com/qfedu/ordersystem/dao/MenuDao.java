package com.qfedu.ordersystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.ordersystem.entry.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuDao extends BaseMapper<Menu> {

    @Results(id = "menu",value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "fname", column = "f_name")
    })
    @Select("select * from menu where level = #{level}")
    @ResultType(Menu.class)
    List<Menu> selectAllByType( Menu menu);

    @Results(id = "fmenu",value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "fname", column = "f_name")
    })
    @Select("select * from menu  where f_name like CONCAT('%',#{fname},'%')")
    @ResultType(Menu.class)
    List<Menu> selectFood(String fname);



    @Select ("SELECT m.*,s.stock FROM menu m INNER JOIN menu_stock s ON m.parent = 3 AND m.id = s.mid;")
    Menu queryAllDrinks();

    Menu selectById(int id);
}
