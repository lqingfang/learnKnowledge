package org.lqf.learn.springDeepLearn.customTag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("/customTagTest.xml");
        User user = (User)bf.getBean("testbean");
        System.out.println(user.getUserName()+"  "+user.getEmail());
    }
}
