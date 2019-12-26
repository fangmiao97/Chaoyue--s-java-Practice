package DesignPatterns.StrategyPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/26 13:20
 * @Description：具体策略类
 */
public class AirPlane extends Plane {

    private String type = "客机";
    @Override
    public void takeOffChar() {
        System.out.println(type + "长距离起飞");
    }

    @Override
    public void fightChar() {
        System.out.println(type + "亚音速飞行");
    }
}
