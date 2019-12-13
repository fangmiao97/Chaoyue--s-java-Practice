package DesignPatterns.CompositePattern;

/**
 * 抽象构件
 */
public abstract class Component {
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract Component getChild(int i);
    public abstract void print();
}
