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

    static int myAge = 22;

    public Me() {
        System.out.println("I am what I am");
    }

    static {
        System.out.println("Me static code");
    }
}

public class StaticBlockTest {
    public static void main(String[] args) {

        //有new的话会执行对象构造方法
        //Me me = new Me();
//        System.out.println(me.myAge);

        //没有new，只是调用一个今天的变量，就不会执行构造方法
        System.out.println(Me.parentAge);
    }
}
