package org.lqf.learn.springAop.throwInteceptor;

import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("11111111111:"+name);

        throw new RuntimeException("Error");
    }
}
