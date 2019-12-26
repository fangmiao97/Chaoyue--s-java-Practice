package DesignPatterns.StrategyPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/26 13:05
 * @Description：策略模式
 * 环境类 - 使用算法的角色
 * 抽象策略类 - 声明了算法的抽象方法
 * 策略类 - 各种不同的算法
 * Sunny软件公司欲开发一款飞机模拟系统，该系统主要模拟不同种类飞机的飞行特征与起飞特
 * 征。
 * 环境类：飞机模拟系统
 * 抽象策划类：飞机
 */
public class Client {
    public static void main(String[] args) {
        Plane plane1 = new AirPlane();
        plane1.fightChar();
        plane1.takeOffChar();

        Plane plane2 = new Fighter();
        plane2.fightChar();
        plane2.takeOffChar();
    }
}
