package CoreJavaVolumeI._0501_ClassSuperClassSubClass;

/**
 * Created by wy on 2016-07-24.
 */
public class Sub extends Super {

    public static void main(String[] args) {
        Sub t = new Sub();
        t.funStatic();
        t.funFinal();
        t.funPrivate();
        System.out.println("====Sub = Sub====>>><<<====Super = Sub====");
        Super t2 = t;
        t2.funStatic();
        t2.funFinal();
//        t2.funPrivate();
    }
    /**
     * 测试静态绑定static方法
     */
    public static void funStatic() {
        System.out.println(Sub.class.getName() + ": " + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试静态绑定fianl方法
     */
//    public final void funFinal() {}

    /**
     * 测试静态绑定private方法
     */
    private void funPrivate() {
        System.out.println(Sub.class.getName() + ": " + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }
}
