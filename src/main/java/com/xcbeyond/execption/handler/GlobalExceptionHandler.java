package com.xcbeyond.execption.handler;

import com.xcbeyond.execption.BusinessException;
import com.xcbeyond.execption.SystemException;
import com.xcbeyond.execption.data.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 * @Auther: xcbeyond
 * @Date: 2019/5/28 15:19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务逻辑异常。
     *  HTTP响应状态为200
     * @param businessException
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity businessExceptionHandler(BusinessException businessException) {
        Result result = businessException.getResult();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 系统异常。
     *  HTTP响应状态为400
     * @param systemException
     * @return
     */
    @ExceptionHandler(value = SystemException.class)
    public ResponseEntity systemExceptionHandler(SystemException systemException) {
        Result result = systemException.getResult();
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }
}