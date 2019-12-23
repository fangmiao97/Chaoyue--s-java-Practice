package DesignPatterns.MementoPattern;

import java.util.ArrayList;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/23 11:41
 * @Description：管理者/负责人 保存历史信息，并返回历史状态
 */
public class Caretaker {
    private ArrayList<Memento> mementos = new ArrayList<>();

    //得历史状态
    public Memento getMemento(int i) {
        return mementos.get(i);
    }

    public void setMemento(Memento memento) {
        mementos.add(memento);
    }
}
