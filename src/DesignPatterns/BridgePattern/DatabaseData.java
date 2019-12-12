package DesignPatterns.BridgePattern;

/**
 * 抽象类
 * 数据库数据
 */
public abstract class DatabaseData {
    //关联关系-桥
    protected FormatImp formatImp;

    public void setFormatImp(FormatImp formatImp) {
        this.formatImp = formatImp;
    }

    //业务方法
    public abstract void parseDataInDB(String dataName);
}
