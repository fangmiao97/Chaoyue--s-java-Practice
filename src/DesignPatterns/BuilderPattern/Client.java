package DesignPatterns.BuilderPattern;

/**
 * 建造者模式
 * Sunny软件公司欲开发一个视频播放软件，为了给用户使用提供方便，该播放软件提供多
 * 种界面显示模式，如完整模式、精简模式、记忆模式、网络模式等。在不同的显示模式
 * 下主界面的组成元素有所差异，如在完整模式下将显示菜单、播放列表、主窗口、控制
 * 条等，在精简模式下只显示主窗口和控制条，而在记忆模式下将显示主窗口、控制条、
 * 收藏列表等。尝试使用建造者模式设计该软件
 *
 * Product - 界面显示模式： 菜单、播放列表、主窗口、控制条
 * Builder - 显示模式Builder
 * ConcreteBuilder - 具体显示模式Builder: 完整模式、精简模式、记忆模式
 * Director - 指导类
 */
public class Client {

    public static void main(String[] args) {

        InterfaceBuilder interfaceBuilder = new MemoryModeBuilder();
        DisplyDirector displyDirector = new DisplyDirector();
        displyDirector.setInterfaceBuilder(interfaceBuilder);

        InterfaceDisplay interfaceDisplay = displyDirector.construct();

        System.out.println(interfaceDisplay.getControl_bar());
        System.out.println(interfaceDisplay.getMain_window());
        System.out.println(interfaceDisplay.getMenu());
        System.out.println(interfaceDisplay.getPlay_queue());
    }

}
