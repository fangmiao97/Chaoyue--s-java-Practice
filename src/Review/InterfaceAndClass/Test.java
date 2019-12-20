package Review.InterfaceAndClass;

/**
 * The java instanceof operator is
 * used to test whether the object is an instance of the specified type
 * (class or subclass or interface)
 */
class C implements A, B {

    @Override
    public void printA() {
        System.out.println("AAA");
    }

    @Override
    public void printB() {
        System.out.println("BBB");
    }
}
public class Test {
    public static void main(String[] args) {
        A a = new C();
        B b = (B) a;
        b.printB();
        System.out.println(a instanceof A);
        System.out.println(a instanceof B);
        System.out.println(a instanceof C);
        System.out.println(b instanceof A);
        System.out.println(b instanceof B);
        System.out.println(b instanceof C);
    }
}
