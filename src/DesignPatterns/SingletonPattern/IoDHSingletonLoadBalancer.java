package DesignPatterns.SingletonPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * initialization-on demand Holder
 * 实现一个负载均衡器Load Balancer
 * 当一个类被jvm加载的时候，会经历初始化的过程。
 * 在多线程环境下，jvm对一个类的初始化会做限制，
 * 同一时间只会允许一个线程去初始化一个类，
 * 这样就从虚拟机层面避免了大部分单例实现的问题
 */
public class IoDHSingletonLoadBalancer {
    //可用服务器集合
    private List serverList = null;

    //私有构造方法
    private IoDHSingletonLoadBalancer() {
        serverList = new ArrayList();
    }

    //静态类，直到jvm确定其会被使用，才会初始化
    //也就是在执行getInstance的时候，才会初始化LazyHolder，并初始化静态变量instance
    private static class LazyHolder {
        //注意这里是static final，即常量。说明不需要实例化LazyHolder这个类来得到instance，
        //因为常量在 准备 阶段已经被赋为最终值，即执行了new constructor().
        static final IoDHSingletonLoadBalancer instance = new IoDHSingletonLoadBalancer();
    }

    public static IoDHSingletonLoadBalancer getInstance() {
        return LazyHolder.instance;
    }

    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }

    //删除
    public void removeServer(String server) {
        serverList.remove(server);
    }

    //分配服务器（随机）
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }

    public static void main(String[] args) {
        IoDHSingletonLoadBalancer LB1, LB2, LB3;
        LB1 = IoDHSingletonLoadBalancer.getInstance();
        LB2 = IoDHSingletonLoadBalancer.getInstance();
        LB3 = IoDHSingletonLoadBalancer.getInstance();

        if(LB1 == LB2 && LB2 == LB3 && LB1 == LB3) {
            System.out.println("same instance");
        }

        LB1.addServer("server 1");
        LB1.addServer("server 2");
        LB1.addServer("server 3");
        LB1.addServer("server 4");

        for (int i = 0; i < 10; i++) {
            String server = LB1.getServer();
            System.out.println("get server" + server);
        }
    }
}
