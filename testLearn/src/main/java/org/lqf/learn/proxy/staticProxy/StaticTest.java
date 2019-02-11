package org.lqf.learn.proxy.staticProxy;

public class StaticTest {
    public static void main(String[] args) {
        Hello staticHelloImpl = new StaticHelloImpl();
        staticHelloImpl.say("jay");
    }
}
