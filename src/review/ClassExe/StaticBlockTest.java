package review.ClassExe;

import java.util.Map;

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

    static {
        System.out.println("GrandParent static code");
    }
}

class Parent extends GrandParent {
    public Parent() {
        System.out.println("I am Parent");
    }

    static {
        System.out.println("Parent static code");
    }
}

class Me extends Parent {
    public Me() {
        System.out.println("I am what I am");
    }

    static {
        System.out.println("Me static code");
    }
}

public class StaticBlockTest {
    public static void main(String[] args) {
        Me me = new Me();
    }
}
