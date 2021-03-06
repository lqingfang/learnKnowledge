package org.smart4j.framework02.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {
    /**
     * 加载属性文件，该属性文件必须在项目的根路径下
     * @param 属性文件名称
     * @return
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try{
            // 加载配置文件
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + "file is not found");
            }
            props = new Properties();
            props.load(is);
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            if (is != null) {
                try{
                    is.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return props;
    }
    /**
     * 获取字符型属性（默认值为空字符串）
     * @param props Properties对象
     * @param key 配置文件中的的属性名
     * @return
     */
    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }
    /**
     * 获取字符型属性（可指定默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.contains(key)) {
            value = props.getProperty(key);
        }
        return value;
    }
    /**
     * 获取数值型属性（默认值为0）
     * @param props Properties对象
     * @param key 配置文件中的的属性名
     * @return
     */
    public static int getInt(Properties props, String key) {
        return getInt(props, key, 0);
    }
    /**
     * 获取数值型属性（可指定默认值）
     * @param props Properties对象
     * @param key 配置文件中的的属性名
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }
    /**
     * 获取布尔型属性（默认值为false）
     * @param props Properties对象
     * @param key 配置文件中的的属性名
     * @return
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }
    /**
     * 获取布尔型属性（可指定默认值）
     * @param props Properties对象
     * @param key 配置文件中的的属性名
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Properties props, String key, Boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }

}
