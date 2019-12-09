package DesignPatterns.Prototype.generalShallowClone;

/**
 * 具体原形类 实现 抽象原型类（这里是Object）
 */
public class WeeklyLog implements Cloneable {//实现Cloneable
    private String name;
    private String date;
    private String content;

    //克隆方法
    //浅克隆，引用对象只复制一份地址
    public WeeklyLog clone() {
        Object object = null;
        try {
            object =  super.clone();
            return (WeeklyLog) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("can not clone!");
            e.printStackTrace();
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
