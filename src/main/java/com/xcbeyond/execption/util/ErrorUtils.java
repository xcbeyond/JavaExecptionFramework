package com.xcbeyond.execption.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 错误工具类，用于从错误码配置文件中获取错误提示信息等
 * @Auther: xcbeyond
 * @Date: 2019/5/24 17:16
 */
public class ErrorUtils {
    private static final Logger log = LoggerFactory.getLogger(ErrorUtils.class);

    private static ResourceBundleMessageSource resourceBundle = new ResourceBundleMessageSource();
    private static final String ZH_LANGUAGE = "CHINESE";
    private static final String EN_LANGUAGE = "AMERICAN/ENGLISH";
    private static final String FILE_KEYWORKS = "error";
    private static final String JAR_RESOURCES = "classpath*:error/*error*.properties";
    private static final String RESOURCES = "classpath*:*error*.properties";


    /**
     * 静态代码块。
     * 用于加载错误码配置文件
     */
    static {
        try {
            PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
            List nameListCn = new ArrayList();

            Resource[] jarResources = patternResolver.getResources(JAR_RESOURCES);
            if (log.isDebugEnabled())
                log.debug("加载CLASSPATH下[error]文件夹错误码配置文件[" + jarResources.length + "]");
            for (Resource resource : jarResources) {
                String fileName = resource.getFilename();
                fileName = fileName.substring(0, fileName.indexOf(FILE_KEYWORKS) + 5);
                if (log.isDebugEnabled())
                    log.debug("加载[error]下错误码配置文件[" + resource.getFilename() + "][" + fileName + "]");
                nameListCn.add("error/" + fileName);
            }

            Resource[] resources = patternResolver.getResources(RESOURCES);
            if (log.isDebugEnabled())
                log.debug("加载CLASSPATH根目录错误码配置文件[" + resources.length + "]");
            for (Resource resource : resources) {
                String fileName = resource.getFilename();
                fileName = fileName.substring(0, fileName.indexOf(FILE_KEYWORKS) + 5);
                if (log.isDebugEnabled())
                    log.debug("加载错误码配置文件[" + resource.getFilename() + "][" + fileName + "]");
                nameListCn.add(fileName);
            }
            resourceBundle.setBasenames((String[]) nameListCn.toArray(new String[0]));

            resourceBundle.setCacheSeconds(5);
        } catch (Throwable localThrowable) {
        }
    }

    /**
     * 获取错误码描述信息
     * @param errCode 错误码
     * @return
     */
    public static String getErrorDesc(String errCode) {
        return getErrorDesc(errCode, "CHINESE");
    }

    /**
     * 获取错误码描述信息
     * @param errCode   错误码
     * @param userLang  国际化语言
     * @return
     */
    public static String getErrorDesc(String errCode, String userLang) {
        String errDesc = "";
        try {
            if ((null == userLang) || (ZH_LANGUAGE.equals(userLang))) {
                errDesc = resourceBundle.getMessage(errCode, null, Locale.SIMPLIFIED_CHINESE);
            } else if (EN_LANGUAGE.equals(userLang)) {
                errDesc = resourceBundle.getMessage(errCode, null, Locale.US);
            }
        } catch (NoSuchMessageException localNoSuchMessageException) {

        }
        return errDesc;
    }

    /**
     * 获取错误码描述信息
     * @param errCode   错误码
     * @param args  错误描述信息中参数
     * @return
     */
    public static String getParseErrorDesc(String errCode, String[] args) {
        return getParseErrorDesc(errCode, ZH_LANGUAGE, args);
    }

    /**
     * 获取错误码描述信息
     * @param errCode   错误码
     * @param userLang  国际化语言
     * @param args  错误描述信息中参数
     * @return
     */
    public static String getParseErrorDesc(String errCode, String userLang, String[] args) {
        String errDesc = "";
        try {
            if ((null == userLang) || (ZH_LANGUAGE.equals(userLang)))
                errDesc = resourceBundle.getMessage(errCode, args, Locale.SIMPLIFIED_CHINESE);
            else if (EN_LANGUAGE.equals(userLang))
                errDesc = resourceBundle.getMessage(errCode, args, Locale.US);
        } catch (NoSuchMessageException localNoSuchMessageException) {
        }
        return errDesc;
    }
}