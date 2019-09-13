package review;

public class TypeConvertTest {
    public static void main(String[] args) {
        short i = (short)(10/10.2*2);//注意括号的位置和添加
        System.out.println(i);
        System.out.println((short)10/10.2*2);//(short)只对最近的10有用
    }
}
