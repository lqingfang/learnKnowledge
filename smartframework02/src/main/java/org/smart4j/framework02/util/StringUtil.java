package org.smart4j.framework02.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    /**
     * 按照指定字符分割字符串
     * @param str
     * @param splitStr
     * @return
     */
    public static String[] splitString(String str, String splitStr) {
        return str.split(splitStr);
    }
}
