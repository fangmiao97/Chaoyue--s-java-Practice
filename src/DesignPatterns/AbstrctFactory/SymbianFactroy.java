package DesignPatterns.AbstrctFactory;

/**
 * Symbian 产品族创建
 */
public class SymbianFactroy implements ControllerFactory{
    @Override
    public OperationController produceOperationController() {
        return new SymbianOperationController();
    }

    @Override
    public InterfaceController produceInterfaceController() {
        return new SymbianInterfaceController();
    }
}
