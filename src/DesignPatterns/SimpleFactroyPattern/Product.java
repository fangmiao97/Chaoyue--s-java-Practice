package DesignPatterns.SimpleFactroyPattern;

//抽象产品类 也可以用接口实现
//定义一些公用方法
abstract class Product {
    public void methodSame() {
        System.out.println("common method");
    }

    //子类各自实现的业务代码
    public abstract void bussinessMethod();
}
