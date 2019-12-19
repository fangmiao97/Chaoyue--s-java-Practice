package DesignPatterns.CommandPattern;

/**
 * 调用者
 */
public class MenuItem {

    private AbstractCommand command;

    public MenuItem(AbstractCommand command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}
