package DesignPatterns.FacadePattern;

/**
 * 子系统 电扇
 */
public class Fan {
    public void on() {
        System.out.println("电扇开");
    }

    public void off() {
        System.out.println("电扇关");
    }
}
