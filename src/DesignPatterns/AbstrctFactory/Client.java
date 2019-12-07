package DesignPatterns.AbstrctFactory;

/**
 * 一个工厂可以提供多个产品对象
 * 产品等级结构：即产品的继承结构，一个总的抽象类，如电视机，下面是具体各个品牌的电视机
 * 产品族：一个工厂生产的，位于不同产品等级结构中的一组商品，如
 *        海尔工厂生产海尔电视机，洗衣机，冰箱
 *
 * 工厂模式针对的是一个工程等级结构，而抽象工厂模式需要面对多个产品等级结构
 * 一个工厂等级结构可以负责多个不同产品等级结构中的产品对象的创建
 * 每一个具体工厂可以生产属于一个产品族中的所有产品
 *
 * 包含：
 * AbstractFactory抽象工厂：声明一组用于创建一族产品的方法，每个方法对应一个产品
 * ConcreteFactory具体工厂：实现了在抽象工厂中声明的方法，生成具体的产品
 * AbstractProduct：声明接口、方法
 * ConcreteProduct：定义具体产品对象，实现抽象产品中定义的业务方法
 *
 * 该模式如果想要添加新的产品等级结构，如，添加吸尘器，就会破坏开闭原则
 *
 * 使用场景：更换皮肤/主题（多个按钮。文本框等组件的外观要同时修改）
 */
public class Client {
    public static void main(String[] args) {
        ControllerFactory controllerFactory;
        OperationController operationController;
        InterfaceController interfaceController;
        controllerFactory= (ControllerFactory) XMLUtil.getBean();
        operationController = controllerFactory.produceOperationController();
        operationController.opControl();
        interfaceController = controllerFactory.produceInterfaceController();
        interfaceController.inControl();
    }
}
