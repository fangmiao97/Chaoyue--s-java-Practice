package review;

public class BooleanTest {
    public static void main(String[] args) {
        Boolean aBoolean = new Boolean(null);
        Boolean aNull = new Boolean("null");

        Boolean aBoolean2 = new Boolean(false);
        Boolean aBoolean1 = new Boolean(true);

        //Boolean参数为String时，只有为“true”，才会是true
        Boolean aTrue = new Boolean("true");

        System.out.println(aBoolean);
        System.out.println(aNull);
        System.out.println(aBoolean2);
        System.out.println(aBoolean1);
        System.out.println(aTrue);
    }
}
