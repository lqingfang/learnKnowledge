package org.lqf.learn.springAop.weaveAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/weave/springWeave.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");
        greetingImpl.sayHello("lily");

        Apology apology = (Apology)greetingImpl;
        apology.saySorry("lily");
    }
}
