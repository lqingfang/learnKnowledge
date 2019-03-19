package org.lqf.learn.springAop.weaveAop;

import org.lqf.learn.springAop.xmlMethod.Greeting;
import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("11111111111:"+name);
    }
}
