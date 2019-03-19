package org.lqf.learn.springAop.throwInteceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/throw/springThrow.xml");
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.sayHello("jam");

    }
}
