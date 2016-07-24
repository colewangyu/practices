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
}
