package Review;

/**
 * try和catch中有return finally块中都会执行，
 * 但是不会再执行try-catch-finally后面的语句了
 *
 * 如果try-catch-finally块中try和catch块都有return语句 / finally块中有return，
 * 则在try-catch-finally后面就添加不了语句（unreachable）
 *
 * 想要执行try-catch-finally后面的语句，在try-catch-finally流程中不能有return（这个是很自然的）
 *
 * 其实只要记住一点，就是finally中的语句在不管怎样都要执行，除非：
 * 1.try-catch-finally块之前就有return，这个情况idea已经会报错了。或者代码写错了，在前面就停了
 * 2.try-catch中有system.exit(0)
 */
public class TryCatchFinallyTest {

    public static String sRet = "";
    public static void block(int i) {
        try {
            sRet += "try_";
            if(i % 2 == 0)
                throw new Exception();
//            return;
        }catch (Exception e) {
            sRet += "catch_";
            return;
        }finally {
            sRet += "finally";//catch或try中有return，当执行完finally中的语句就不会往下执行了
        }

        sRet += "_blockEnd;";

    }

    public static int returnValue() {
        int i = 1;
        try {
            System.out.println("try block");
            return i;//在执行finally块中的语句之前，该值被保存了。
            // 假如在finally中有return，那么这里的return就被覆盖了
            //也就是说在finally执行之前会将这里这个return的值算出来，
            // 比方说如果return sum(),会先算出这个函数的值，然后保存
            // 等到finally块结束了，就return
        }catch (Exception e) {
            System.out.println("catch block");
            return i;
        }finally {
            System.out.println("finally block");
            i++;
            System.out.println("i in finally block is "+i);
        }
    }

    public static void main(String[] args) {


        block(1);
        System.out.println(sRet);
        sRet = "";
        System.out.println();

        block(2);
        System.out.println(sRet);
        System.out.println();

        System.out.println("return value is " + returnValue());

        System.out.println();
        //System.out.println("before try");
        //return;
        try {
            System.out.println("try Block");
            return;
        }catch (Exception e){
            System.out.println("catch block");
            return;
        }
        finally {
            System.out.println("finally Block");//try有return finally依然会执行
            return;
        }

    }
}
