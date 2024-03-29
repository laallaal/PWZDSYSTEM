package com.qfedu.ordersystem.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * 自定义响应结构
 * @author Stream
 */
public class JsonUtils {
    /**
     * 定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper ();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     *
     * @param data object类型数据
     * @return 返回json数据
     */
    public static String objectToJson(Object data) {
        try {
            return MAPPER.writeValueAsString (data);
        } catch (JsonProcessingException e) {
            e.printStackTrace ();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return 返回实体类
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            return MAPPER.readValue (jsonData, beanType);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     *
     * @param jsonData json数据
     * @param beanType 数据类型
     * @return 返回List集合
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory ().constructParametricType (List.class, beanType);
        try {
            return MAPPER.readValue (jsonData, javaType);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return null;
    }

}