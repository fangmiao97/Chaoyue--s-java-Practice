package reflaction;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> clz = Class.forName("reflaction.Student");
        Method[] methods = clz.getMethods();//父类的方法也在里面
        for (Method m: methods) {
            System.out.println("方法名：" + m.getName());
        }

        Method[] declaredMethods = clz.getDeclaredMethods();
        for (Method m: declaredMethods) {
            System.out.println("该类定义的方法：" + m.getName());
        }

        //调用类的方法
        Student stu = (Student) clz.newInstance();
        System.out.println(stu.getName());//null
        //获取方法
        Method setName = clz.getMethod("setName", String.class);
        setName.invoke(stu, "FANGMIAO");
        System.out.println(stu.getName());

        //获取public属性
        Field[] fields = clz.getFields();
        for (Field f: fields) {
            System.out.println("属性名" + f.getName());
        }

        //操作属性，包括private
        Field name = clz.getDeclaredField("name");
        name.setAccessible(true);//private设置权限
        name.set(stu, "RINA");
        System.out.println(stu.getName());

    }
}
