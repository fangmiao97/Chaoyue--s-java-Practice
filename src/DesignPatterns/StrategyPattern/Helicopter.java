package DesignPatterns.StrategyPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/26 13:14
 * @Description：具体策略类
 */
public class Helicopter extends Plane {

    private String type = "直升机";

    @Override
    public void takeOffChar() {
        System.out.println(type + " 垂直起飞");
    }

    @Override
    public void fightChar() {
        System.out.println(type + "亚音速飞行");
    }
}
