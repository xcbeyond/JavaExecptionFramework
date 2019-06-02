package com.xcbeyond.execption.util;

import com.xcbeyond.execption.BusinessException;
import com.xcbeyond.execption.SystemException;
import com.xcbeyond.execption.data.Result;

/**
 * 异常工具类
 * @Auther: xcbeyond
 * @Date: 2019/5/27 09:37
 */
public class ExecptionUtils {
    /**
     * 业务处理异常
     * @param errCode   异常码
     * @return
     */
    public static BusinessException businessException(String errCode) {
        return new BusinessException(createResult(errCode));
    }

    /**
     * 业务处理异常
     * @param errCode   异常码
     * @param args  错误描述信息中的参数
     * @return
     */
    public static BusinessException businessException(String errCode, String... args) {
        return new BusinessException(createResult(errCode, args));
    }

    /**
     * 系统级异常
     * @param errCode   异常码
     * @return
     */
    public static SystemException systemException(String errCode) {
        return new SystemException(createResult(errCode));
    }

    /**
     * 系统级异常
     * @param errCode   异常码
     * @param args  错误描述信息中的参数
     * @return
     */
    public static SystemException systemException(String errCode, String... args) {
        return new SystemException(createResult(errCode, args));
    }


    private static Result createResult(String errCode) {
        return new Result(errCode, getErrorMsg(errCode));
    }

    private static Result createResult(String errCode, String msg) {
        return new Result(errCode, msg);
    }

    private static Result createResult(String errCode, String[] args) {
        return new Result(errCode, getErrorMsg(errCode, args));
    }

    /**
     * 获取错误信息
     * @param errCode   错误码
     * @return
     */
    private static String getErrorMsg(String errCode) {
        return ErrorUtils.getErrorDesc(errCode);
    }

    /**
     * 获取错误信息
     * @param errCode   错误码
     * @param args  错误描述信息中的参数
     * @return
     */
    private static String getErrorMsg(String errCode, String[] args) {
        return ErrorUtils.getParseErrorDesc(errCode, args);
    }

}
