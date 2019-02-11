package org.lqf.learn.proxy.staticProxy;

public class StaticHelloImpl implements Hello{
    Hello hello = new HelloImp();

    public void say(String name) {
        befor();
        hello.say(name);
        after();
    }
    private void befor(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}

