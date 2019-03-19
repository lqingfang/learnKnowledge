package org.lqf.learn.springAop.beforeAndAfter;

import org.lqf.learn.springAop.baseAop.Greeting;
import org.lqf.learn.springAop.baseAop.GreetingImpl;
import org.springframework.aop.framework.ProxyFactory;

public class Test {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("jack");
    }
}
