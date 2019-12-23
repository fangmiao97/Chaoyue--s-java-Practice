package DesignPatterns.MementoPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/23 11:27
 * @Description：原发器 - 保存特定时间点的游戏信息
 */
public class GameInfo {
    private String scene;//场景
    private String mission;//任务
    private String roleInfo;//角色信息

    private Caretaker caretaker;

    public GameInfo(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    //保存当前状态位置的索引
    private static int index = -1;

    //只有在业务类中可以操作（修改）Memento类
    public Memento saveMemento() {
        index++;
        return new Memento(scene, mission, roleInfo);
    }

    //恢复undo操作，由历史memento修改现在的状态
    public void restoreMemento(Memento memento) {
        this.scene = memento.getScene();
        this.mission = memento.getMission();
        this.roleInfo = memento.getRoleInfo();
    }

    public void undo() {
        index--;
        restoreMemento(caretaker.getMemento(index));
    }

    public void show() {
        System.out.println("场景：" + this.scene);
        System.out.println("任务：" + this.mission);
        System.out.println("角色信息：" + roleInfo);
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }
}
