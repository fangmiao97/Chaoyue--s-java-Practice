package DesignPatterns.ObserverPattern;

import java.util.EventObject;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/24 19:56
 * @Description：
 */
public class LoginEvent extends EventObject
{
    private String userName;
    private String password;
    public LoginEvent(Object source,String userName,String password)
    {
        super(source);
        this.userName=userName;
        this.password=password;
    }
    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    public String getUserName()
    {
        return this.userName;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return this.password;
    }
}
