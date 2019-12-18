package Review;

public class WrapperClassTest {
    public static void main(String[] args) {
        String a = new String("abc");
        String b = "abc";
        System.out.println(a == b);
        System.out.println(a.equals(b));

        Integer one = 100;
        Integer two = 100;
        System.out.println(one == two);

        //对于这样直接赋值的Integer 当值的范围在
        //[-128,127] 时候 会不生成新的对象 直接把缓存中的对对象拿来用
        //Integer a=128;Integer b=128
        //这样的话就是false了
        Integer three = 128;
        Integer four = 128;
        System.out.println(three == four);

    }
}
