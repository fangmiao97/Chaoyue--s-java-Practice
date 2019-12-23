package DesignPatterns.MementoPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/23 11:23
 * @Description：备忘录模式
 * 使用一个属性和业务类（原发器类）相同的备忘录类来存储特定时刻的对象状态，
 * 并通过一个负责人类来存储和获取这些历史状态
 * Sunny软件公司正在开发一款RPG网游，为了给玩家提供更多方便，在游戏过程中可以设
 * 置一个恢复点，用于保存当前的游戏场景，如果在后续游戏过程中玩家角色“不幸牺牲”，
 * 可以返回到先前保存的场景，从所设恢复点开始重新游戏。试使用备忘录模式设计该功
 * 能。
 * 原发器/业务类 - 网游场景信息
 * 备忘录
 * 负责人 保存前一个恢复点
 */
public class Client {
    //保存当前状态位置的索引
    private static int index = -1;

    private static Caretaker caretaker = new Caretaker();

    public static void main(String[] args) {
         GameInfo gameInfo = new GameInfo(caretaker);
         gameInfo.setScene("召唤师峡谷");
         gameInfo.setMission("任务1");
         gameInfo.setRoleInfo("角色1金币2323");
         gameInfo.show();
         caretaker.setMemento(gameInfo.saveMemento());
         gameInfo.setScene("NTU");
         gameInfo.setMission("seek for job");
         caretaker.setMemento(gameInfo.saveMemento());
         gameInfo.show();
         gameInfo.undo();
         gameInfo.show();
    }
}
