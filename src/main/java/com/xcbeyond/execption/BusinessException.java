package com.xcbeyond.execption;

import com.xcbeyond.execption.data.Result;


/**
 * 业务处理异常
 * @Auther: xcbeyond
 * @Date: 2018/12/24 11:20
 */
public class BusinessException extends BaseException {
    private Result result = new Result();

    public BusinessException(Result result) {
        super(result.getStatusCode()+ ":" + result.getMsg());
        this.result = result;
    }

    public BusinessException(String code, String msg) {
        super(code + ":" + msg);
        this.result.setStatusCode(code);
        this.result.setMsg(msg);
    }

    public BusinessException(Result result, Throwable cause) {
        super(result.getStatusCode() + ":" + result.getMsg(), cause);
        this.result = result;
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(code + ":" + msg, cause);
        this.result.setStatusCode(code);
        this.result.setMsg(msg);
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
