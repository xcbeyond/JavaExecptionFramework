package com.xcbeyond.execption;

import java.io.Serializable;

/**
 * 异常基类
 * @Auther: xcbeyond
 * @Date: 2019/5/28 16:27
 */
public class BaseException extends RuntimeException implements Serializable {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
