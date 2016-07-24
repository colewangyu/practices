package CoreJavaVolumeI._0501_ClassSuperClassSubClass;

/**
 * Created by wy on 2016-07-24.
 */
public abstract class AbstractClass {
    private String name;

    public AbstractClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
//        AbstractClass c = new AbstractClass("cole");
        AbstractClass c1 = new SubClass("cole");
    }
}

class SubClass extends AbstractClass {
    public SubClass(String name) {
        super(name);
    }
}
