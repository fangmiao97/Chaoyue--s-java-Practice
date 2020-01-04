package DesignPatterns.AbstrctFactory;

public class AndroidFactory implements ControllerFactory {
    @Override
    public OperationController produceOperationController() {
        return new AndroidOperationController();
    }

    @Override
    public InterfaceController produceInterfaceController() {
        return new AndroidInterfaceController();
    }
}
