package org.lqf.learn.proxy.cglibProxyOpt;

public class CGLibTest {
    public static void main(String[] args) {

        Hello hello = CGLibProxy.getInstance().getProxy(Hello.class);
        hello.say("jay");
    }
}
