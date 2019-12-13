package DesignPatterns.CompositePattern;

/**
 * 叶子构件
 */
public class Button extends Component{

    public String name;

    public Button(String name) {
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
        System.out.println("打印按钮" + name);
    }
}
