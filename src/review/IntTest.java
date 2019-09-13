package review;

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
        System.out.println(Integer.rotateLeft(1024, 2));

    }
}