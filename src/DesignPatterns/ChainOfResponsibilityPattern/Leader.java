package DesignPatterns.ChainOfResponsibilityPattern;

/**
 * 抽象处理者
 */
public abstract class Leader {

    protected String name;
    protected Leader successor;

    public Leader(String name) {
        this.name = name;
    }

    //用于在客户端中设置职责链
    public void setSuccessor(Leader successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(LeaveRequest leaveRequest);

}
