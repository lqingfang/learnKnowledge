package org.smart4j.framework03.proxy;

public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
