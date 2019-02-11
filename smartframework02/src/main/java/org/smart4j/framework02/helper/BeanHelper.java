package org.smart4j.framework02.helper;

import org.smart4j.framework02.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    定义Bean映射
    BEAN_MAP里面存的是Bean类，Bean实体的映射关系，相当于"Bean容器"
 */
public final class BeanHelper {
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }
    }
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls) {
        if(!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class:" + cls);
        }
        return (T)BEAN_MAP.get(cls);
    }
    public static void setBean(Class<?> cls,Object obj) {
        BEAN_MAP.put(cls,obj);
    }
}
