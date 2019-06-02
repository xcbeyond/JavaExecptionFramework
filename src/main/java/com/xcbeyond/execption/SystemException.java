package com.xcbeyond.execption;

import com.xcbeyond.execption.data.Result;

/**
 * 系统级异常。
 *  指系统级别的，如：网络通信时连接中断、系统连接、超时等异常
 * @Auther: xcbeyond
 * @Date: 2019/5/28 16:26
 */
public class SystemException extends BaseException{
    private Result result = new Result();

    public SystemException(Result result) {
        super(result.getStatusCode()+ ":" + result.getMsg());
        this.result = result;
    }

    public SystemException(String code, String msg) {
        super(code + ":" + msg);
        this.result.setStatusCode(code);
        this.result.setMsg(msg);
    }

    public SystemException(Result result, Throwable cause) {
        super(result.getStatusCode() + ":" + result.getMsg(), cause);
        this.result = result;
    }

    public SystemException(String code, String msg, Throwable cause) {
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
