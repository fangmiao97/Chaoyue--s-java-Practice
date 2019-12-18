package DesignPatterns.ChainOfResponsibilityPattern;

/**
 * Chain of Responsibility Pattern
 * 职责链模式
 * 在客户端定义职责链
 * 定义抽象处理者 和 具体处理者
 *
 * Sunny软件公司的OA系统需要提供一个假条审批模块：如果员工请假天数小于3天，主任
 * 可以审批该假条；如果员工请假天数大于等于3天，小于10天，经理可以审批；如果员工
 * 请假天数大于等于10天，小于30天，总经理可以审批；如果超过30天，总经理也不能审
 * 批，提示相应的拒绝信息。试用职责链模式设计该假条审批模块。
 *
 * 抽象处理者：领导
 * 具体处理者：经理、总经理
 */
public class Client {
    public static void main(String[] args) {
        Leader xjp,jzm;
        xjp = new Manager("习近平");
        jzm = new GeneralManager("江泽民");

        //创建职责链
        xjp.setSuccessor(jzm);

        LeaveRequest l1 = new LeaveRequest();
        l1.setDays(4);
        l1.setName("宋楚瑜");
        xjp.handleRequest(l1);

        LeaveRequest l2 = new LeaveRequest();
        l2.setName("韩国瑜");
        l2.setDays(15);
        xjp.handleRequest(l2);

        LeaveRequest l3 = new LeaveRequest();
        l3.setDays(40);
        l3.setName("蔡英文");
        xjp.handleRequest(l3);
    }
}
