package org.lqf.learn.springAop.xmlMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/xmlMethod/spring.xml");
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.sayHello("jam");
    }
}
