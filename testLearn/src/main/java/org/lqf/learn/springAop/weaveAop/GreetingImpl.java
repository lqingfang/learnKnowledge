package org.lqf.learn.springAop.weaveAop;

import org.springframework.stereotype.Component;

@Component
public class GreetingImpl{
    public void sayHello(String name) {
        System.out.println("11111111111:"+name);
    }
}
