package review;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hhhe");
        System.out.println(s);
        s.append("trtr");
        System.out.println(s);
        String str = new String("huuh");

        StringBuilder sb = new StringBuilder();
        sb.append(3);
        sb.append(4);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
