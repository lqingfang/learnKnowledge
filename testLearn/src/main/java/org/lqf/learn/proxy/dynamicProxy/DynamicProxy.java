package org.lqf.learn.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    private void befor(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}
