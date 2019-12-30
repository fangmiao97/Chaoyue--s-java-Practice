package Review.ClassExe;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/29 23:20
 * @Description：Class,forName()和Class字面量
 * 获取Class对象引用的方式3种，
 * 通过继承自Object类的getClass方法，
 * Class类的静态方法forName以及字面常量的方式”.class”。
 */

class DangerousWomen {
    static {
        System.out.println("Dangerous women static block");
    }

    DangerousWomen() {
        System.out.println("Dangerous Women construct method");
    }
}

public class ForNameMethed {
    public static void main(String[] args) throws ClassNotFoundException {

//        System.out.println("之前没有初始化，会先加载class，即执行static里面的代码");
//        DangerousWomen dangerousWomen = new DangerousWomen();

        //static只会在类第一次加载时执行
        //返回指定类的class对象，没有new 就不会执行构造方法。
        Class clazz = Class.forName("Review.ClassExe.DangerousWomen");
        System.out.println(clazz.getName());

        System.out.println("使用new实例化一个对象时，执行构造方法");
        DangerousWomen d = new DangerousWomen();
        Class clazz2 = d.getClass();
        System.out.println(clazz2.getName());

        System.out.println("使用class字面量也可以得到Class对象的引用,而且不会出发类的初始化，即不会有static块代码的执行");
//        Class clazz3 = DangerousWomen.class;
//        System.out.println(clazz3.getName());
    }
}
