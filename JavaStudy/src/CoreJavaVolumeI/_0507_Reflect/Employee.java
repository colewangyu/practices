package CoreJavaVolumeI._0507_Reflect;

/**
 * Created by wy on 2016-07-22.
 *
 *  模拟反射的类
 */
public class Employee {
    public Employee(){}
    protected Employee(String name){}
    private Employee(String name, String age){}

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String publicFieldEmployee;
    protected String protectedFieldEmployee;
    private String privateFieldEmployee;

    public void publicMethodEmployee(){}
    protected void protectedMethodEmployee(){}
    private void privateMethodEmployee(){}
}
