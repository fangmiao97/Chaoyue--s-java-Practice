package review;

public class TryCatchFinallyTest {

    public static String sRet = "";
    public static void block(int i) {
//        System.out.println("before");
        try {
            sRet += "try_";
            if(i % 2 == 0)
                throw new Exception();
//            return;
        }catch (Exception e) {
            sRet += "catch_";
            return;
        }finally {
            sRet += "finally";//catch中有return，当执行完finally中的语句就不会往下执行了
        }

        sRet += "_blockEnd;";

    }
    public static void main(String[] args) {


        block(1);
        System.out.println(sRet);
        block(2);
        System.out.println(sRet);

        //System.out.println("before try");
        //return;
        try {
            System.out.println("try Block");
            return;
        }catch (Exception e){
            return;
        }
        finally {
            System.out.println("finally Block");//try有return finally依然会执行
            return;
        }

    }
}
