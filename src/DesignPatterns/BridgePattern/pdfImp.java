package DesignPatterns.BridgePattern;

/**
 * concrete implement
 */
public class pdfImp implements FormatImp{

    @Override
    public void doParse(String data) {
        System.out.println(data + "parse in pdf and display");
    }
}
