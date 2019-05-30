package com.xcbeyond.execption.data;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.xcbeyond.execption.util.ObjectUtils;

import java.io.Serializable;

/**
 * 返回结果
 * @Auther: xcbeyond
 * @Date: 2019/5/24 17:55
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Result implements Serializable {
    //状态码
    private String statusCode;
    //提示信息
    private String msg;
    //结果数据
    private Object data;

    public Result() {

    }

    public Result(String statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 重写toString方法，让Result对象以json字符串形式存在
     * @return
     *  Json字符串
     */
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("statusCode", this.statusCode);
        json.put("msg", this.msg);
        if (null != this.data) {
            json.put("data", ObjectUtils.modelToMap(this.data));
        }
        return json.toJSONString();
    }
}