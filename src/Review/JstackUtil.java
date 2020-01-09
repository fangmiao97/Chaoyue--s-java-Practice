package Review;

import java.util.Map;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/7 20:09
 * @Description：使用jstack查看线程堆栈信息
 */
public class JstackUtil {
    /**
     * @Description: 得线程堆栈信息
     * @Param:  []
     * @Return: java.lang.String
     * @Author: FANG MIAO
     * @Date: 2020/1/7 22:31
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static String getJavaStackTrace() {
        StringBuilder msg = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> stackTrace
                : Thread.getAllStackTraces().entrySet()) {
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stackTraceElements = stackTrace.getValue();
//            if (thread.equals(Thread.currentThread())) {
//                continue;
//            }
            msg.append("\n线程：")
                    .append(thread.getName()).append("\n");
            for (StackTraceElement element : stackTraceElements) {
                msg.append("\t").append(element).append("\n");
            }
        }
        return msg.toString();
    }

    public static void main(String[] args) {
        String msg = getJavaStackTrace();
        System.out.println(msg);
    }
}

