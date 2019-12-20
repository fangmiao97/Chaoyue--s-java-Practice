package Review;

public class AndTest {
    public static void main(String[] args) {
        String str = new String();
        System.out.println(str != null);//引用不为null
        System.out.println(str.equals(""));//内容为空
        boolean one = str != null & !str.equals("");
        boolean two = str != null && !str.equals("");
        System.out.println(one);
        System.out.println(two);
    }
}
