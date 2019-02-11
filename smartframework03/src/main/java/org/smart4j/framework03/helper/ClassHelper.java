package org.smart4j.framework03.helper;

import org.smart4j.framework03.annotation.Controller;
import org.smart4j.framework03.annotation.Service;
import org.smart4j.framework03.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public final class ClassHelper {
    /*
       定义类集合（用于存放所加载的类）
     */
    private static final Set<Class<?>> CLASS_SET;
    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }
    //获取应用包下所有类
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }
    //获取包下所有Service类
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET) {
            if(cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
    //获取包下所有Controller类
    public static Set<Class<?>> getControlerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET) {
            if(cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
    //获取包下所有Service,Controller类
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getControlerClassSet());
        classSet.addAll(getServiceClassSet());
        return classSet;
    }
    //获取应用包名下某父类（或接口）的所有子类（或实现类）
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET) {
            //superClass.isAssignableFrom(cls)  如果cls是superClass的子类，返回true
            if(superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
    //获取应用包名下带有某注解的所有类
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET) {
            if(cls.isAnnotationPresent(annotationClass)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
}
