package review;

class A {
    public void foo() {
        System.out.println("Afoo");
    }
}

class B extends A {
    @Override
    public void foo() {
        System.out.println("Bfoo");
    }
}
public class ExtendsTest {
    public static void main(String[] args) {
        A a = new B();
        B b = (B) a;
        a.foo();
        b.foo();
    }

}
