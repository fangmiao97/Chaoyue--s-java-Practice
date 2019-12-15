package DesignPatterns.FacadePattern;

/**
 * facade pattern 外观模式
 * 使用一个外观类将客户端和子系统解耦
 */
public class Client {
    public static void main(String[] args) {
        FacilityFacade facade = new FacilityFacade();
        facade.on();
        facade.off();
    }
}
