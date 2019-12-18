package DesignPatterns.ChainOfResponsibilityPattern;

/**
 * 具体处理类
 */
public class Manager extends Leader{

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getDays() <= 10) {
            System.out.println("经理" + this.name + "审批" + leaveRequest.getName() + leaveRequest.getDays() + "天的请假条");
        }else {
            if (this.successor != null) {
                this.successor.handleRequest(leaveRequest);
            }
        }
    }
}
