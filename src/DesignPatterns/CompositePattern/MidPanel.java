package DesignPatterns.CompositePattern;

import java.util.ArrayList;

/**
 * 容器构件
 */
public class MidPanel extends Component {

    public String name;

    public ArrayList<Component> componentArrayList = new ArrayList<Component>();

    public MidPanel(String name) {
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
        System.out.println("打印中间面板" + name);
        for (Component component : componentArrayList) {
            component.print();
        }
    }
}
