package DesignPatterns.BridgePattern;

/**
 * refinedAbstraction
 */
public class MysqlData extends DatabaseData {
    @Override
    public void parseDataInDB(String dataName) {
        formatImp.doParse("mysql data" + dataName);
    }
}
