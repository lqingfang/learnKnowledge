package org.lqf.learn.springAop.throwInteceptor;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class GreetingThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(Method method,Object[] args,Object target,Exception e) {
        System.out.println("-----Throw---");
    }
}
