package review;

public class AndTest {
    public static void main(String[] args) {
        String str = new String();
        boolean one = str != null & !str.equals("");
        boolean two = str != null && !str.equals("");
        System.out.println(one);
        System.out.println(two);
    }
}
