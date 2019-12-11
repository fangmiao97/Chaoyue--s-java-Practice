package DesignPatterns.AdapterPattern;

/**
 * 实际已有的加密算法，提供的接口与target（dataOperation）不一致
 */
public final class Cipher {
    public String encrypt(int key, String ps) {
        String res = "";
        for (int i = 0; i < ps.length(); i++) {
            String c = String.valueOf(ps.charAt(i) % key);
            res += c;
        }
        return res;
    }
}
