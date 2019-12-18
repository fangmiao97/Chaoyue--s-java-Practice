package Review;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用Unsafe加monitor锁（这就是synchronized隐式加的锁）
 */

public class UnsafeInstance {
    public static Unsafe reflectGetUnsafe() {
        try {
            Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);
            return (Unsafe) unsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
