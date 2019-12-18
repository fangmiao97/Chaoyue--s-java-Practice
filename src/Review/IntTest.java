package Review;

public class IntTest {
    public static void main(String[] args) {
        Integer n = 23;
        System.out.println(n);
        Integer a = new Integer("12234");
        System.out.println(a + n);

        String bin = Integer.toBinaryString(1024);
        String oct = Integer.toOctalString(1024);
        String hex = Integer.toHexString(1024);
        System.out.println(bin + "\n" + oct + "\n" + hex);
        //二进制左移2位，相当于乘4
        System.out.println(Integer.rotateLeft(1024, 2));

        int b = '1';
        System.out.println(b);

        //Integer存的是对象引用
        Integer m = new Integer(23);
        System.out.println(n == m);

        //和Integer n = 23 一样
        int n1 = 23;
        System.out.println(n == n1);

    }
}