package DesignPatterns.BuilderPattern;

/**
 * 具体创建类 - 完整模式Full Mode
 */
public class FullModeBuilder extends InterfaceBuilder{

    @Override
    public void buildMenu() {
        interfaceDisplay.setMenu("完整模式-菜单");
    }

    @Override
    public void buildPlayQueue() {
        interfaceDisplay.setPlay_queue("完整模式-播放列表");
    }

    @Override
    public void buildMainWindow() {
        interfaceDisplay.setMain_window("完整模式-主窗口");
    }

    @Override
    public void buildControlBar() {
        interfaceDisplay.setControl_bar("完整模式-控制条");
    }
}
