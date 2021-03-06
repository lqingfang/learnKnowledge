package org.smart4j.framework03.util;

import org.apache.commons.lang3.ArrayUtils;

//数组工具类
public class ArrayUtil {
    /**
     * 判断数组是否为空
     * @param array Object[]
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }
    /**
     * 判断数组是否为空
     * @param array Object[]
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
