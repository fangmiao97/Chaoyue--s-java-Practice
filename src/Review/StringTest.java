package Review;

/**
 * StringBuffer - synchronized
 * 效率：
 * StringBuilder > StringBuffer > String
 */
public class StringTest {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hhhe");
        System.out.println(s);
        s.append("trtr");
        System.out.println(s);

        //new是在堆区中进行，每次new出来的都是不同的
        String str = new String("taiwan no1");
        String str2 = new String("taiwan no1");
        System.out.println(str == str2);

        //在编译期间生成了字面常量和字符引用，
        // 这部分叫做class文件常量池；
        // 在运行期间对应着方法区的运行时常量池（相同的字符串内容只保留一份）
        String str1  = "taiwan no1";
        String str3 = "taiwan no1";
        System.out.println("str1 == str3 "+ (str1 == str3));
        System.out.println(str == str1);

        //编译期间b已经被优化成hello2，所以a b指向同一个对象
        String a = "hello2";
        String b = "hello" + 2;
        System.out.println("a == b ? " + (a == b));

        //c中有符号引用，不能被优化，c是在堆上生成的
        String d = "hello";
        String c = d + 2;
        System.out.println("c == a ? " + (c == a));

        //对于被final修饰的变量，会在class文件常量池中保存一个副本
        //不会通过连接来访问
        //final变量在编译期间就被替换成真实值
        final String e = "hello";
        c = e + 2;
        System.out.println("c == a ? " + (c == a));

        StringBuilder sb = new StringBuilder();
        sb.append(3);
        sb.append(4);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
