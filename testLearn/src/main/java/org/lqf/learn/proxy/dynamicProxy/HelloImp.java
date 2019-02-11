package org.lqf.learn.proxy.dynamicProxy;



public class HelloImp implements Hello{
    public void say(String name) {
        System.out.println("hello,"+name);
    }
}
