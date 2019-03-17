package org.lqf.learn.eventListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    private static ApplicationContext context;
    private MessageSource resources;

    static {
        context =  new FileSystemXmlApplicationContext("/listenTest.xml");
    }
    public static void main(String[] args) {
        context.publishEvent(new DIYEvent("-----"));
    }
}
