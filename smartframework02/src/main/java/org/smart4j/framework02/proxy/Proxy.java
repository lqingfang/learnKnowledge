package org.smart4j.framework02.proxy;

public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
