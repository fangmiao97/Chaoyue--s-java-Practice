package DesignPatterns.BridgePattern;

/**
 * 具体实现类- txt
 */
public class txtImp implements FormatImp {
    @Override
    public void doParse(String data) {
        System.out.println(data + "parse in txt format and display");
    }
}
