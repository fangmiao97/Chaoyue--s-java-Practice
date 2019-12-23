package DesignPatterns.MementoPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/23 11:32
 * @Description：备忘录类 - 保存业务类在特定时刻的信息
 */
public class Memento {
    private String scene;//场景
    private String mission;//任务
    private String roleInfo;//角色信息

    public Memento(String scene, String mission, String roleInfo) {
        this.scene = scene;
        this.mission = mission;
        this.roleInfo = roleInfo;
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
