package DesignPatterns.AdapterPattern;

/**
 * 抽象类或接口
 * 现在定义写的，供Client调用的接口方法
 */
public abstract class DataOperation {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String encrypy(int key, String password);
}
