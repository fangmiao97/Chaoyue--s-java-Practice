package DesignPatterns.CompositePattern;

/**
 * Composite Pattern 组合模式
 * Component 抽象类
 * leaf 叶子构件 不能再有子构件
 * container 容器构件 可包含容器构件和子构件
 * 使用透明组合模式
 * Sunny软件公司欲开发一个界面控件库，界面控件分为两大类，一类是单元控件，例如按
 * 钮、文本框等，一类是容器控件，例如窗体、中间面板等，试用组合模式设计该界面控
 * 件库。
 */
public class Client {
    public static void main(String[] args) {
        Component window, midPanel, button1, button2, textbox;
        window = new Window("郭老师直播间");
        midPanel = new MidPanel("直播窗口");
        button1 = new Button("1");
        button2 = new Button("2");
        textbox = new Textbox("评论");

        window.add(midPanel);
        window.add(midPanel);
        window.add(button2);
        midPanel.add(button1);
        midPanel.add(textbox);

        window.print();
    }
}
