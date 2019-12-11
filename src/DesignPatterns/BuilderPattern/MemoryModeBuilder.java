package DesignPatterns.BuilderPattern;

/**
 * 具体创建类 - Memory Mode
 */
public class MemoryModeBuilder extends InterfaceBuilder{
    @Override
    public void buildMenu() {
        interfaceDisplay.setMenu("记忆模式-菜单");
    }

    @Override
    public void buildPlayQueue() {
        interfaceDisplay.setPlay_queue("记忆模式-播放列表");
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
        interfaceDisplay.setMain_window("记忆模式-主窗口");
    }

    @Override
    public void buildControlBar() {
        interfaceDisplay.setControl_bar("记忆模式-控制条");
    }
}
