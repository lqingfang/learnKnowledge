package org.lqf.learn.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        return (T)Enhancer.create(cls,this);
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        befor();
        Object result = methodProxy.invokeSuper(o,args);
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
