package DesignPatterns.AdapterPattern;

/**
 * 适配器类
 */
public class CipherAdapter extends DataOperation{

    private Cipher cipher;

    public CipherAdapter() {
        this.cipher = new Cipher();
    }

    @Override
    public String encrypy(int key, String password) {
        return cipher.encrypt(key, password);
    }
}
