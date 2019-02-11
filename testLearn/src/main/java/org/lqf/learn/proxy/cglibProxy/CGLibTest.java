package org.lqf.learn.proxy.cglibProxy;

public class CGLibTest {
    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        Hello hello = cgLibProxy.getProxy(Hello.class);
        hello.say("jay");
    }
}
