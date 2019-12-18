package Review;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> subSet = new TreeSet<>();

        for(int i = 606; i < 613; i++) {
            if(i % 2 == 0)
                set.add(i);
        }

        subSet = (TreeSet<Integer>) set.subSet(608, true, 611, true);
        set.add(629);
        System.out.println(set);
        System.out.println(subSet);
    }
}
