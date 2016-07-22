package CoreJavaVolumeI._0507_Reflect;

/**
 * Created by wy on 2016-07-22.
 *
 * 模拟反射的类
 */
public class Manager extends Employee {
    public Manager(){}
    protected Manager(String name) {}
    private Manager(String name, String managerType) {}

    public String publicFieldManager;
    protected String protectedFieldManager;
    private String privateFieldManager;

    public void publicMethodManager(){}
    protected void protectedMethodManager(){}
    private void privateMethodManager(){}
}
