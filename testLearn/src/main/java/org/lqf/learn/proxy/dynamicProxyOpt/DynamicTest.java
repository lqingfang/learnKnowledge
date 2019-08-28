package org.lqf.learn.proxy.dynamicProxyOpt;


public class DynamicTest {
    public static void main(String[] args) {

        Hello hello = new DynamicProxy(new HelloImp()).getProxy();
        hello.say("jay");
    }
}
