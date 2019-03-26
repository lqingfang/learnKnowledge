package org.lqf.learn.springAop.springAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("aop/springAop/aop.xml");

        HelloWorld hw1 = (HelloWorld)ctx.getBean("helloWorldImpl");
        hw1.printHelloWorld();
        hw1.doPrint();

        System.out.println("----------");

        HelloWorld hw2 = (HelloWorld)ctx.getBean("helloWorldImpl02");
        hw2.printHelloWorld();
        hw2.doPrint();
    }
}
