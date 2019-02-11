package org.lqf.learn.proxy.dynamicProxyOpt;


public class DynamicTest {
    public static void main(String[] args) {

        Hello hello = DynamicProxy.getInstance().getProxy();
        hello.say("jay");
    }
}
