package Review;

public interface InterfaceTest {
    public static final int variable = 0;//默认public static final
    //方法默认 public abstract

    //默认方法允许您添加新的功能到现有库的接口中，
    // 并能确保与采用旧版本接口编写的代码的二进制兼容性。
    //可以在接口中实现的方法
    default int foo(){
        return 1;
    }
}
