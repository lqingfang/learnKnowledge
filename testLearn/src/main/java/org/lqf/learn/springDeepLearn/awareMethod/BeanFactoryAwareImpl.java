package org.lqf.learn.springDeepLearn.awareMethod;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanFactoryAwareImpl implements BeanFactoryAware {
    private static BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
    public static void testAware() {
        Hello hello = (Hello) beanFactory.getBean("hello");
        hello.say();
    }
}
