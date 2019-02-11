package org.smart4j.framework02.proxy;

import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;


public abstract class AspectProxy implements Proxy{
    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();//获取目标类
        Method method = proxyChain.getTargetMethod();//目标方法
        Object[] params = proxyChain.getMethodParams();//目标参数
        begin();
        try {
            if(intercept(cls,method,params)) {
                before(cls,method,params);
                result = proxyChain.doProxyChain();
                after(cls,method,params,result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            logger.error("proxy failure",e);
            error(cls,method,params,e);
            throw e;
        }finally {
            end();
        }

        return result;
    }
    public void begin() {}
    public boolean intercept(Class<?> cls,Method method,Object[] params) {
        return true;
    }
    public void before(Class<?> cls, Method method,Object[] params) {}
    public void after(Class<?> cls, Method method,Object[] params,Object result) {}
    public void error(Class<?> cls, Method method,Object[] params,Throwable e) {}
    public void end() {}
}
