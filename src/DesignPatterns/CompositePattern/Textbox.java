package DesignPatterns.CompositePattern;

/**
 * 叶子构件
 */
public class Textbox extends Component {

    public String name;

    public Textbox(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        System.out.println("构件不支持此操作");
    }

    @Override
    public void remove(Component component) {
        System.out.println("构件不支持此操作");
    }

    @Override
    public Component getChild(int i) {
        System.out.println("构件不支持此操作");
        return null;
    }

    @Override
    public void print() {
        System.out.println("打印文本框" + name);
    }
}
