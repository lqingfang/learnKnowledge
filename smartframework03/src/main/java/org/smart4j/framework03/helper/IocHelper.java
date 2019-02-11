package org.smart4j.framework03.helper;

import org.smart4j.framework03.annotation.Inject;
import org.smart4j.framework03.util.ArrayUtil;
import org.smart4j.framework03.util.CollectionUtil;
import org.smart4j.framework03.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

public final class IocHelper {
    static {
        //获取所有bean,bean实例  对应关系
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)) {
            for(Map.Entry<Class<?>,Object> beanEntity : beanMap.entrySet()) {
                //遍历beanMap
                Class<?> beanClass = beanEntity.getKey();
                Object beanInstance = beanEntity.getValue();
                //获取所有成员变量（getDeclaredFields 包括私有变量）
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)) {
                    for(Field beanField : beanFields) {
                        //如果成员变量有该注解
                        if(beanField.isAnnotationPresent(Inject.class)) {
                            //获取对应类名
                            Class<?> beanFieldClass = beanField.getType();
                            //获取实例
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldClass != null) {
                                //反射初始化beanField的值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}

