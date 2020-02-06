package DesignPatterns.AdapterPattern;

/**
 * 适配器类，继承了target
 */
public class CipherAdapter extends DataOperation{

    private Cipher cipher;//关联adaptee

    public CipherAdapter() {
        this.cipher = new Cipher();
    }

    @Override
    public String encrypy(int key, String password) {
        return cipher.encrypt(key, password);
    }
}
