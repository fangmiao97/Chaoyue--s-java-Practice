package DesignPatterns.Prototype.DeepClone;

import java.io.IOException;

/**
 * deep clone 原型模式
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WeeklyLog weeklyLog1, weeklyLog2;
        Attachment attachment1 = new Attachment();
        attachment1.setName("week1 attachment");

        weeklyLog1 = new WeeklyLog();
        weeklyLog1.setAttachment(attachment1);
        weeklyLog1.setContent("ffff");
        weeklyLog1.setDate("1209");
        weeklyLog1.setName("FM");

        weeklyLog2 = weeklyLog1.deepClone();

        //深拷贝 引用对象是不相同的 false
        System.out.println(weeklyLog1.getAttachment() == weeklyLog2.getAttachment());
    }
}
