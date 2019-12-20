package Review;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        String b = "test";
        final String a = b;
        String  c = "test2";
        //a = c; error a is final variable cannot refer to another reference

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        System.out.println(list.toArray()[0]);
        System.out.println(list.toArray()[1]);
        System.out.println(list.toArray()[2]);
    }
}
