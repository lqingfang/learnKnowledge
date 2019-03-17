package org.lqf.learn.eventListener;

import org.springframework.context.ApplicationEvent;

public class DIYEvent extends ApplicationEvent {
    public DIYEvent(Object source) {
        super(source);
    }
}

