package DesignPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;

/**
 * 代理模式 proxy pattern
 * 针对抽象主题角色编程
 * 代理类和真正主题角色继承抽象主题类，实现相同的业务功能
 */
public class Client {
    public static void main(String[] args) {
        InvocationHandler proxy = null;
        AbstrctSubject abstrctSubject = null;

        proxy = new Proxy(new RealSubject());
        abstrctSubject = (AbstrctSubject) java.lang.reflect.Proxy.newProxyInstance(AbstrctSubject.class.getClassLoader(), new Class[]{AbstrctSubject.class}, proxy);
        abstrctSubject.request();

        System.out.println("--------");

        proxy = new Proxy(new RealSubjectB());
        abstrctSubject = (AbstrctSubject) java.lang.reflect.Proxy.newProxyInstance(AbstrctSubject.class.getClassLoader(), new Class[]{AbstrctSubject.class}, proxy);
        abstrctSubject.request();
    }
}
