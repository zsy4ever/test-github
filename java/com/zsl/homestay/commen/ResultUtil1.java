package com.zsl.homestay.commen;

import org.apache.catalina.connector.Response;

public class ResultUtil1 {

    public static Result success(Object object) {
        21212121
        Result result = new Result();
        result.setCode(Response.SC_OK);
        result.setMessage("操作成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
