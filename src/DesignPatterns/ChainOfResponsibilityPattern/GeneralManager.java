package DesignPatterns.ChainOfResponsibilityPattern;

/**
 * 具体处理类
 */
public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getDays() <= 30) {
            System.out.println("总经理" + this.name + "审批" + leaveRequest.getName() + leaveRequest.getDays() + "天的请假条");
        }else {
            System.out.println(leaveRequest.getName()+"请这么多天，别上班了。滚吧");
        }
    }
}
