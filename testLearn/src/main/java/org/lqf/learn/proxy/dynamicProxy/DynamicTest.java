package org.lqf.learn.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicTest {
    public static void main(String[] args) {
        Hello hello = new HelloImp();

        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello helloProxy = (Hello)Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                dynamicProxy
        );
        helloProxy.say("jay");
    }
}
