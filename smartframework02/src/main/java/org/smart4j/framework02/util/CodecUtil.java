package org.smart4j.framework02.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

public final class CodecUtil {
    /*
    将url编码
     */
    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source,"UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return target;
    }
    /*
    将URL解码
     */
    public static String decodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source,"UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return target;
    }
}
