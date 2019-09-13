package structrue.skipList;

public class TestSkipList {
    public static void main(String[] args) {
        SkipList<String> list=new SkipList<String>();
        System.out.println(list);
        list.put(2, "T");
        list.put(1, "T");
        list.put(3, "U");
        list.put(1, "N");//测试同一个key值
        list.put(4, "新");
        list.put(6, "坡");
        list.put(5, "加");
        System.out.println(list);
        System.out.println(list.size());
    }
}
