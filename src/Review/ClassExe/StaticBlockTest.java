package Review.ClassExe;

/**
 * 调用顺序
 * 父类的静态代码块
 * 子类的静态代码块
 * 父类的构造方法
 * 子类的构造方法
 */

class GrandParent {
    public GrandParent() {
        System.out.println("I am GrandParent");
    }

    static int GrandPaAge = 100;

    static {
        System.out.println("GrandParent static code");
    }
}

class Parent extends GrandParent {
    public Parent() {
        System.out.println("I am Parent");
    }

    static int parentAge = 44;
    static {
        System.out.println("Parent static code");
    }
}

class Me extends Parent {

    static final int staticFinal = 23;

    public final int justFinalInt = 99;//必须要实例化才能用

    static int myAge = 22;

    public Me() {
        System.out.println("I am what I am");
    }

    static {
        System.out.println("Me static code");
    }

    public static void staticMethod(){
        System.out.println("Me static method");
    }
}

public class StaticBlockTest {

    static {
        System.out.println("包含main方法的主类会最先初始化");
    }

    public static void main(String[] args) {

        //static final修饰的类变量（编译期静态变量）不会引发初始化
        System.out.println("static final修饰的类变量"+Me.staticFinal);

        Me one = new Me();
        System.out.println(one.justFinalInt);//只用final修饰的是常量，需要实例化一个对象才可以用
        //one.justFinalInt = 34;报错，因为常量不能修改

        //调用静态方法，读取静态字段（只有static修饰的类变量）都会初始化
         System.out.println(Me.myAge);
//        Me.staticMethod();

        //有new的话会执行对象构造方法
//        Me me = new Me();
//        System.out.println(me.myAge);

        //没有new，只是调用一个静态的变量，就不会执行构造方法
        //System.out.println(Me.parentAge);
    }
}
