package DesignPatterns.ChainOfResponsibilityPattern;

/**
 * 请假条，客户端请求处理的类
 */
public class LeaveRequest {
    private String name;
    private int days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
