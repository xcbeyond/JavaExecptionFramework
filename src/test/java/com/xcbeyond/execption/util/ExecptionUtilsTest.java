package com.xcbeyond.execption.util;

import org.junit.Test;

/**
 * @Auther: xcbeyond
 * @Date: 2019/5/28 10:41
 */
public class ExecptionUtilsTest {

    @Test
    public void businessException() {
        String username = null;
        if (null == username) {
            throw ExecptionUtils.businessException("EE3001");
        }
    }

    @Test
    public void businessException2() {
        String username = "xcbeyond";

        if ("xcbeyond".equals(username)) {
            throw ExecptionUtils.businessException("EE4001",username);
        }
    }
}