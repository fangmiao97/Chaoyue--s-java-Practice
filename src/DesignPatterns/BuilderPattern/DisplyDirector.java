package DesignPatterns.BuilderPattern;

/**
 * 指导类
 */
public class DisplyDirector {
    private InterfaceBuilder interfaceBuilder;

    public void setInterfaceBuilder(InterfaceBuilder interfaceBuilder) {
        this.interfaceBuilder = interfaceBuilder;
    }

    public InterfaceDisplay construct() {
        if (interfaceBuilder.isMenu()) {
            interfaceBuilder.buildMenu();
        }

        if (interfaceBuilder.isPlayQueue()) {
            interfaceBuilder.buildPlayQueue();
        }

        if (interfaceBuilder.isMainWindow()) {
            interfaceBuilder.buildMainWindow();
        }

        if (interfaceBuilder.isControlBar()) {
            interfaceBuilder.buildControlBar();
        }

        return interfaceBuilder.getInterfaceDisplay();

    }
}
