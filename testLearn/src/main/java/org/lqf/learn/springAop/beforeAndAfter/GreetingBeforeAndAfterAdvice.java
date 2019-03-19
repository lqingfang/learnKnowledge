package org.lqf.learn.springAop.beforeAndAfter;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingBeforeAndAfterAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        after();
        return result;
    }
    private void before() {
        System.out.println("0000000-----00000");
    }
    private void after() {
        System.out.println("22222----22222");
    }
}
