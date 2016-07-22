package CoreJavaVolumeI._0507_Reflect;

import java.lang.reflect.*;

/**
 * Created by wy on 2016-07-22
 * <p>
 * Java反射基础学习.
 */
public class Reflect {
    /**
     * 获取Class对象的第一种办法：通过对象实例获取
     */
    public void getClassByMethod() {
        Employee e = new Manager();
        e.setName("cole");
        Class clz = e.getClass();
        System.out.println(clz.getName() + " " + e.getName());
        e = new Employee();
        e.setName("mary");
        clz = e.getClass();
        System.out.println(clz.getName() + " " + e.getName());
    }

    /**
     * 获取Class对象的第二种办法：通过类名字获取（包内的需带包名）
     */
    public void getClassByName() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Employee e;
        Class clz = Class.forName("CoreJavaVolumeI._0507_Reflect.Employee");
        e = (Employee) clz.newInstance();
        e.setName("cole");
        System.out.println(clz.getName() + " " + e.getName());
    }

    /**
     * 获取Class对象的第三种办法：通过类获取
     */
    public void getClassByProperty() throws IllegalAccessException, InstantiationException {
        Employee e;
        Class clz = Employee.class;
        e = (Employee) clz.newInstance();
        e.setName("mike");
        System.out.println(clz.getName() + " " + e.getName());
    }

    /**
     * 测试java.lang.class类的getField()方法
     *
     * @param clzName 类名
     * @throws ClassNotFoundException
     */
    public void getFields(String clzName) throws ClassNotFoundException {
        Class clz = Class.forName(clzName);
        for (Field f : clz.getFields()) {
            System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getName());
        }
    }

    /**
     * 测试java.lang.class类的getMethods()方法
     *
     * @param clzName 类名
     * @throws ClassNotFoundException
     */
    public void getMethods(String clzName) throws ClassNotFoundException {
        Class clz = Class.forName(clzName);
        for (Method m : clz.getMethods()) {
            System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getName());
        }
    }

    /**
     * 测试java.lang.class类的getConstructors()方法
     *
     * @param clzName 类名
     * @throws ClassNotFoundException
     */
    public void getConstructors(String clzName) throws ClassNotFoundException {
        Class clz = Class.forName(clzName);
        for (Constructor c : clz.getConstructors()) {
            System.out.println(Modifier.toString(c.getModifiers()) + " " + c.getName());
        }
    }

    /**
     * 测试java.lang.class类的getDeclaredFields()方法
     *
     * @param clzName 类名
     * @throws ClassNotFoundException
     */
    public void getDeclaredFields(String clzName) throws ClassNotFoundException {
        Class clz = Class.forName(clzName);
        for (Field f : clz.getDeclaredFields()) {
            System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getName());
        }
    }

    /**
     * 测试java.lang.class类的getDeclaredMethods()方法
     *
     * @param clzName 类名
     * @throws ClassNotFoundException
     */
    public void getDeclaredMethods(String clzName) throws ClassNotFoundException {
        Class clz = Class.forName(clzName);
        for (Method m : clz.getDeclaredMethods()) {
            System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getName());
        }
    }

    /**
     * 测试java.lang.class类的getDeclaredConstructors()方法
     *
     * @param clzName 类名
     * @throws ClassNotFoundException
     */
    public void getDeclaredConstructors(String clzName) throws ClassNotFoundException {
        Class clz = Class.forName(clzName);
        for (Constructor c : clz.getDeclaredConstructors()) {
            System.out.println(Modifier.toString(c.getModifiers()) + " " + c.getName());
        }
    }

    public void getFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Employee e = new Employee();
        e.setName("Cole Wang");
        Class clz = e.getClass();
        //获取到私有属性name
        Field f = clz.getDeclaredField("name");
        //设置私有属性的访问权限（不设置则会收到Java安全机制限制）
        f.setAccessible(true);
        System.out.println(f.get(e));
    }

    public Object CopyOfArray(Object a, int newLength) {
//            (1) 获取反射对象
        Class clz = a.getClass();
//                (2) 判断是否数组对象
        if(!clz.isArray()) return null;
//                (3) 获取数组类型和长度
        Class componentType = clz.getComponentType();
        int length = Array.getLength(a);
//                (4) 创建新的数组实例
        Object newArray = Array.newInstance(componentType, newLength);
//                (5) 将内容复制到新的数组中
        System.arraycopy(a,0,newArray,0,Math.min(newLength,length));
//                (6) 返回新的数组
        return newArray;
    }
}
