package DesignPatterns.BuilderPattern;

/**
 * 具体创建类 - simply mode
 */
public class SimplyModeBuilder extends InterfaceBuilder{

    @Override
    public void buildMenu() {
        interfaceDisplay.setMenu("精简模式-菜单");
    }

    @Override
    public void buildPlayQueue() {
        interfaceDisplay.setPlay_queue("精简模式-播放列表");
    }

    //覆盖钩子函数，表明有的part不需要创建
    public boolean isMenu() {
        return false;
    }

    public boolean isPlayQueue() {
        return false;
    }

    @Override
    public void buildMainWindow() {
        interfaceDisplay.setMain_window("精简模式-主窗口");
    }

    @Override
    public void buildControlBar() {
        interfaceDisplay.setControl_bar("精简模式-控制条");
    }
}
