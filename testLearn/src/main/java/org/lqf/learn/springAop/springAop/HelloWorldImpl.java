package org.lqf.learn.springAop.springAop;

public class HelloWorldImpl implements HelloWorld {
    public HelloWorldImpl() {
    }

    public void printHelloWorld() {
        System.out.println("impl---");
    }

    public void doPrint() {
        System.out.println("impl---doPrint");
    }
}
