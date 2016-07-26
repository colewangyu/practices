package CoreJavaVolumeI._0502_Object;

import java.util.Objects;

/**
 * Created by wy on 2016-07-24.
 */
public class SubObject extends Object {
    private String name;

    /**
     * 一个完美的equals方法示范
     *
     * @param otherObject
     * @return
     */
    @Override
    public boolean equals(Object otherObject) {
        //检测引用是否相同
        if (this == otherObject) return true;
        //检测otherObject是否为null
        if (otherObject == null) return false;
        //比较this与otherObject是否属于同一个类
            //该类不同的子类被认为不同
        if(this.getClass() != otherObject.getClass()) return false;
            //该类不同子类被认为相同
        if(!(otherObject instanceof SubObject)) return false;
        //强制转换otherObject对象
        SubObject other = (SubObject) otherObject;
        //比较对象的属性是否相同
        if(this.name.equals(other.name)) return true;
        else return false;
    }

    public static void main(String[] args) {
        SubObject s1 = null;
        SubObject s2 = null;
        System.out.println(s1.equals(s2)); //NullPointerException
    }
}
