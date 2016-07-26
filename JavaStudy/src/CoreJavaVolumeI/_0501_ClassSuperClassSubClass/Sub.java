package CoreJavaVolumeI._0501_ClassSuperClassSubClass;

/**
 * Created by wy on 2016-07-24.
 */
public class Sub extends Super {

    public static void main(String[] args) {
        Sub t = new SubSub();
        t.funStatic();
        t.funFinal();
        t.funPrivate();
        System.out.println();
        Super t2 = t;
        t2.funStatic();
        t2.funFinal();
//        t2.funPrivate();  //无法在类外访问private方法
        System.out.println();
        Super t3 = new Sub();
        t3.funDynamic();
    }
    /**
     * 测试静态绑定static方法
     */
    public static void funStatic() {
        System.out.println("被调用类：Sub，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试静态绑定fianl方法
     */
//    public final void funFinal() {}

    /**
     * 测试静态绑定private方法
     */
    private void funPrivate() {
        System.out.println("被调用类：Sub，调用类：" + this.getClass().getName() + "，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试动态绑定
     */
    public void funDynamic() {
        System.out.println("被调用类：Sub，调用类：" + this.getClass().getName() + "，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }
}
