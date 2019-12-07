package DesignPatterns.AbstrctFactory;

/**
 * 控制器抽象工厂
 */
public interface ControllerFactory {
    //产品方法
    public OperationController produceOperationController();
    public InterfaceController produceInterfaceController();
}
