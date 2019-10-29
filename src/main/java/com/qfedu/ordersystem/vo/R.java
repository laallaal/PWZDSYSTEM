package com.qfedu.ordersystem.vo;

import lombok.Data;

@Data
public class R {

    private int code;
    private String msg;
    private Object data;



    public static R getOk(Object data) {

        R r = new R();
        r.setCode(200);
        r.setMsg("OK");
        r.setData(data);

        return r;
    }


    public static R setError() {
        R r = new R();
        r.setCode(400);
        r.setMsg("error");
        r.setData(null);
        return r;
    }
}
