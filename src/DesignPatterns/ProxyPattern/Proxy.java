package DesignPatterns.ProxyPattern;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 */
public class Proxy implements InvocationHandler {

    public Object object;

    public Proxy(Object object) {
        this.object = object;
    }

    public void preRequest() {
        System.out.println("pre request!!");
    }

    public void postRequest() {
        System.out.println("post request!!!");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preRequest();
        method.invoke(object, args);
        postRequest();
        return null;
    }
}
