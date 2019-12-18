package Review;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        map.put(1, 1);//覆盖前面一个
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
        System.out.println(map.get(2));

        map.put(2,4);
        map.put(4,6);

        int lastKey = map.lastKey();
        int lastValue = map.get(lastKey);
        System.out.println(lastKey + " " + lastValue);

        map.put(3,6);
        map.put(5,7);
        map.put(9,1);

        //自然排序-升序（键值）
        for (Map.Entry entry: map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(" : "+entry.getValue());
        }

        System.out.println("--------按key降序排列---------");

        TreeMap<Integer, Integer> mapDec = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }) ;

        mapDec.put(1,2);
        mapDec.put(2,4);
        mapDec.put(5,5);
        mapDec.put(9,4);

        for (Map.Entry entry: mapDec.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("----------按value值排序-------------");

        //先存在没有排序的map里，再用comparator存在TreeMap里
        //unsorted map
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,2);
        hashMap.put(2,3);
        hashMap.put(4,6);
        hashMap.put(6,8);
        hashMap.put(5,1);
        hashMap.put(56,2);


        TreeMap<Integer, Integer> mapSortByValue =
                new TreeMap<>(new ValueComparator(hashMap));
        mapSortByValue.put(1,2);
        mapSortByValue.put(2,3);
        mapSortByValue.put(4,6);
        mapSortByValue.put(6,8);
        mapSortByValue.put(5,1);
        mapSortByValue.put(56,2);


        for (Map.Entry entry : mapSortByValue.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}

class ValueComparator implements Comparator {

    private Map<Integer, Integer> map;

    public ValueComparator(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (map.get(o1) > map.get(o2))
            return 1;
        else if(map.get(o1) < map.get(o2))
            return -1;
        else
            return 0;
    }
}
