package org.lqf.learn.springAop.baseAop;

import org.springframework.aop.framework.ProxyFactory;

public class Test {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("jack");
    }
}
