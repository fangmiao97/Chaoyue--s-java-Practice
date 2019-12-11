package DesignPatterns.BuilderPattern;

/**
 * Product
 */
public class InterfaceDisplay {

    private String menu;
    private String play_queue;
    private String main_window;
    private String control_bar;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPlay_queue() {
        return play_queue;
    }

    public void setPlay_queue(String play_queue) {
        this.play_queue = play_queue;
    }

    public String getMain_window() {
        return main_window;
    }

    public void setMain_window(String main_window) {
        this.main_window = main_window;
    }

    public String getControl_bar() {
        return control_bar;
    }

    public void setControl_bar(String control_bar) {
        this.control_bar = control_bar;
    }
}
