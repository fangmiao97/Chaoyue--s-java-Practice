package DesignPatterns.CommandPattern;

/**
 * receiver - 请求接受者
 * 实现业务逻辑
 */
public class BoardScreen {
    public void open(){
        System.out.println("打开");
    }

    public void create() {
        System.out.println("创建");
    }

    public void edit() {
        System.out.println("编辑");
    }
}
