package review;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {
    public static void main(String[] args) {
        String s = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher matcher = p.matcher(s);
        if(matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
