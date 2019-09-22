package review;

public class CharArrayAndString {
    public static void main(String[] args) {
        String s = "djhfkahjsg";
        System.out.println(s);
        char[] charArray = s.toCharArray();
        String b = new String(charArray);
        System.out.println(b);
    }
}
