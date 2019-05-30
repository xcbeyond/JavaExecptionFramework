package com.xcbeyond.execption.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Object工具类
 * @Auther: xcbeyond
 * @Date: 2019/5/28 16:20
 */
public class ObjectUtils {

    /**
     * 对象转化为Map
     * @param object
     * @return
     */
    public static Map<String, Object> modelToMap(Object object) {
        Map<String, Object> map = new HashMap();
        for (Field field : object.getClass().getDeclaredFields()){
            try {
                boolean flag = field.isAccessible();
                field.setAccessible(true);
                Object o = field.get(object);
                if (null != o) {
                    map.put(field.getName(), o);
                }
                field.setAccessible(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
