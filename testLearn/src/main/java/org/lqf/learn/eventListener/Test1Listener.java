package org.lqf.learn.eventListener;

import org.springframework.context.ApplicationListener;


public class Test1Listener implements ApplicationListener<DIYEvent> {

    public void onApplicationEvent(DIYEvent event) {
        System.out.println(event.getSource());
    }
}
