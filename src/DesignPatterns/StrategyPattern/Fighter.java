package DesignPatterns.StrategyPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/26 13:25
 * @Description：
 */
public class Fighter extends Plane {

    private String type = "歼击机";
    @Override
    public void takeOffChar() {
        super.takeOffChar();
        System.out.println(type + "长距离起飞");
    }

    @Override
    public void fightChar() {
        super.fightChar();
        System.out.println(type + "超音速飞行");

    }
}
