package org.lqf.learn.springAop.springAop;

public class HelloWorldImpl02 implements HelloWorld {
    public HelloWorldImpl02() {
    }

    public void printHelloWorld() {
        System.out.println("impl02");
    }

    public void doPrint() {
        System.out.println("impl02-doPrint");
    }
}
