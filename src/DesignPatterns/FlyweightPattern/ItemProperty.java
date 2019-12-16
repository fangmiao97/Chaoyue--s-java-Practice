package DesignPatterns.FlyweightPattern;

/**
 * 插入元素的大小位置
 * 外部状态
 */
public class ItemProperty {
    public String size;
    public int location;

    public ItemProperty(String size, int location) {
        this.size = size;
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
