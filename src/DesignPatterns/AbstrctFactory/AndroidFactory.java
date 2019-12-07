package DesignPatterns.AbstrctFactory;

public class AndroidFactory implements ControllerFactory {
    @Override
    public OperationController produceOperationController() {
        return null;
    }

    @Override
    public InterfaceController produceInterfaceController() {
        return null;
    }
}
