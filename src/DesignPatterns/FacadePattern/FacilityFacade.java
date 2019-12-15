package DesignPatterns.FacadePattern;

/**
 * 外观类
 */
public class FacilityFacade {
    private Fan fan;
    private AirCon airCon;

    public FacilityFacade() {
        fan = new Fan();
        airCon = new AirCon();
    }

    public void on() {
        fan.on();
        airCon.on();
    }

    public void off() {
        fan.off();
        airCon.off();
    }
}

