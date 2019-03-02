package org.lqf.learn.springDeepLearn.replaced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("/replacedTest.xml");
        TestChangeMethod testChangeMethod = (TestChangeMethod) bf.getBean("testChangeMethod");
        testChangeMethod.changeMe();
    }
}
