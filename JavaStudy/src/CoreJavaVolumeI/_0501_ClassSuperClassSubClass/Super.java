package CoreJavaVolumeI._0501_ClassSuperClassSubClass;

/**
 * Created by wy on 2016-07-24.
 */
public class Super {
    /**
     * 测试静态绑定static方法
     */
    public static void funStatic() {
        System.out.println(Super.class.getName() + ": " + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试静态绑定fianl方法
     */
    public final void funFinal() {
        System.out.println(Super.class.getName() + ": " + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试静态绑定private方法
     */
    private void funPrivate() {
        System.out.println(Super.class.getName() + ": " + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }
}
