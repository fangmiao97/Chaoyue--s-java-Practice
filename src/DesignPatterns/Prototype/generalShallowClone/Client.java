package DesignPatterns.Prototype.generalShallowClone;

public class Client {
    public static void main(String[] args) {
        WeeklyLog weeklyLog1 = new WeeklyLog();
        weeklyLog1.setContent("fuck this world!");
        weeklyLog1.setDate("1209");
        weeklyLog1.setName("FM");

        System.out.println(weeklyLog1.getDate());
        System.out.println(weeklyLog1.getName());
        System.out.println(weeklyLog1.getContent());

        WeeklyLog weeklyLog2 = weeklyLog1.clone();
        weeklyLog2.setDate("1232");

        System.out.println(weeklyLog2.getDate());
        System.out.println(weeklyLog2.getName());
        System.out.println(weeklyLog2.getContent());

        //内存地址不同
        System.out.println(weeklyLog1 == weeklyLog2);

        System.out.println(weeklyLog1.equals(weeklyLog2));
        System.out.println(weeklyLog1.getContent() == weeklyLog2.getContent());
        System.out.println(weeklyLog1.getName() == weeklyLog2.getName());
        System.out.println(weeklyLog1.getDate() == weeklyLog2.getDate());

        //内容相同
        System.out.println(weeklyLog1.getName().equals(weeklyLog2.getName()));

    }
}
