package DesignPatterns.BridgePattern;

public class MongoDBData extends DatabaseData {
    @Override
    public void parseDataInDB(String dataName) {
        formatImp.doParse("mongoDB data" + dataName);
    }
}
