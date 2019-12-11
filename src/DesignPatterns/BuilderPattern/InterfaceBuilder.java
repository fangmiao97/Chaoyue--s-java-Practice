package DesignPatterns.BuilderPattern;

/**
 * abstract builder
 */
public abstract class InterfaceBuilder {

    protected InterfaceDisplay interfaceDisplay = new InterfaceDisplay();
    public abstract void buildMenu();
    public abstract void buildPlayQueue();
    public abstract void buildMainWindow();
    public abstract void buildControlBar();

    //钩子方法，表明某部分是否需要创建
    //默认都创建
    public boolean isMenu() {
        return true;
    }

    public boolean isPlayQueue() {
        return true;
    }

    public boolean isMainWindow() {
        return true;
    }

    public boolean isControlBar() {
        return true;
    }

    public InterfaceDisplay getInterfaceDisplay() {
        return interfaceDisplay;
    }

}
