package LeetCode;

//顺序打印 1 2 3，无论以什么调用顺序
public class PrintInOrder {

    public static void main(String[] args) {

    }

}

class PrintNum implements Runnable{
    int num;
    PrintNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "print number: " + num);

    }
}
