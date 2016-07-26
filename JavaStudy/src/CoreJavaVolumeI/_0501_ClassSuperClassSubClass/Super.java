package CoreJavaVolumeI._0501_ClassSuperClassSubClass;

/**
 * Created by wy on 2016-07-24.
 */
public class Super {
    /**
     * 测试静态绑定static方法
     */
    public static void funStatic() {
        System.out.println("被调用类：Super，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试静态绑定fianl方法
     */
    public final void funFinal() {
        System.out.println("被调用类：Super，调用类：" + this.getClass().getName() + "，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试静态绑定private方法
     */
    private void funPrivate() {
        System.out.println("被调用类：Super，调用类：" + this.getClass().getName() + "，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试动态绑定
     */
    public void funDynamic() {
        System.out.println("被调用类：Super，调用类：" + this.getClass().getName() + "，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }
}
