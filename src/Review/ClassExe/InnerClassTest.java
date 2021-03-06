package Review.ClassExe;

/**
 * 使用static内部类
 */

class Outer {

    static int outArr1 = 1949;
    int outArr2 = 2019;

    public static class Inter {

        static {//只有使用到inner类才会初始化
            System.out.println("inner static class static block code");
        }

        public static int a = 70;
        public static void fun() {
            System.out.println("static Inter can only get static outer attribute outarr1 " + outArr1);
            System.out.println("inter static function");
        }
    }

    class noStaticInter {
//        static int anInt = 0; //非静态内部类中不可以定义static变量和方法
        void fun2() {
            System.out.println("no static inter class can get no static/static attributes in outer class " + outArr2 + outArr1);
        }
    }
}

public class InnerClassTest {
    //Outer.Inter in = new Outer.Inter();

    public static void main(String[] args) {//main就是一个典型的static方法
        Outer outer = new Outer();
        Outer.Inter inter = new Outer.Inter();//注意和非static内部类new方法的不同
        Outer.Inter.fun();//调用静态内部类中静态方法
        System.out.println(Outer.Inter.a);

        //创建普通内部类方法，需要有outer才能new内部的--》outer.new ***
        Outer.noStaticInter noStaticInter = outer.new noStaticInter();
        noStaticInter.fun2();
    }
}
