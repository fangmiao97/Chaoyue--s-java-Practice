package DesignPatterns.CompositePattern;

import java.util.ArrayList;

/**
 * 容器组件
 */
public class Window extends Component {

    private ArrayList<Component> componentArrayList = new ArrayList<Component>();
    private String name;

    public Window(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        componentArrayList.add(component);
    }

    @Override
    public void remove(Component component) {
        componentArrayList.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return componentArrayList.get(i);
    }

    @Override
    public void print() {
        System.out.println("打印窗口" + name);
        for (Component component: componentArrayList) {
            component.print();
        }
    }
}
