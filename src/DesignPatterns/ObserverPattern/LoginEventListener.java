package DesignPatterns.ObserverPattern;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/24 19:56
 * @Description：
 */
import java.util.EventListener;

//Abstract Observer
public interface LoginEventListener extends EventListener
{
    public void validateLogin(LoginEvent event);
}