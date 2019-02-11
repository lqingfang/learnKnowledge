package org.lqf.learn.proxy.dynamicProxyOpt;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    private DynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    public DynamicProxy() {
    }

    private static DynamicProxy dynamicProxy = new DynamicProxy();
    public static DynamicProxy getInstance(){
        return dynamicProxy;
    }
    @SuppressWarnings("unchecked")
    public <T> T getProxy(){
        return (T)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
    private void befor(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}
