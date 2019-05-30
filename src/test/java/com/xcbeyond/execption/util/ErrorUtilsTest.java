package com.xcbeyond.execption.util;

import org.junit.Test;

/**
 *
 * @Auther: xcbeyond
 * @Date: 2019/5/24 17:30
 */
public class ErrorUtilsTest {

    @Test
    public void getErrorDesc() {
        String desc = ErrorUtils.getErrorDesc("MM3001");
        System.out.println(desc);
    }
}
