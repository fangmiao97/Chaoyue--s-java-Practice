package review;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        map.put(1, 1);
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        map.put(2,4);
        map.put(4,6);
        int lastKey = map.lastKey();
        int lastValue = map.get(lastKey);
        map.remove(map.lastKey());
        for (Map.Entry entry: map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
