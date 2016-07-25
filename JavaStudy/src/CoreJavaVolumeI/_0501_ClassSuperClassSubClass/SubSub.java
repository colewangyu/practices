package CoreJavaVolumeI._0501_ClassSuperClassSubClass;

/**
 * Created by wy on 2016-07-24.
 */
public class SubSub extends Sub {
    public static void main(String[] args) {
        Super t = new Sub();
        //子类可以强转成父类，父类不能强转成子类（父类包含子类，强转会丢失数据）
//        t = ((SubSub) t);
        System.out.println(t instanceof SubSub);
        System.out.println(t.getClass() == Super.class);
        t.funStatic();
    }

    /**
     * 测试静态绑定private方法
     */
    private void funPrivate() {
        System.out.println("被调用类：SubSub，调用类：" + this.getClass().getName() + "，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    /**
     * 测试动态绑定
     */
    public void funDynamic() {
        System.out.println("被调用类：SubSub，调用类：" + this.getClass().getName() + "，调用方法：" + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }
}
