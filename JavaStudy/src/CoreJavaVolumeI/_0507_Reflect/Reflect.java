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

    /**
     * 章节：5.7.4 在运行时使用反射分析对象
     *
     * 测试运行时使用反射获取对象某个属性的值。
     *
     * 步骤：
     *		①. 获取对象的Class对象
     *		②. 获取对应的Field属性
     *		③. 设置该Field属性的可访问性
     *		④. 读取该Field属性的值
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public void getFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Employee e = new Employee();
        Employee e2 = new Employee();
        e.setName("Cole Wang");
        e2.setName("Cole");
        Class clz = e.getClass();
        //获取到私有属性name
        Field f = clz.getDeclaredField("name");
        //设置私有属性的访问权限（不设置则会收到Java安全机制限制）
        f.setAccessible(true);
        //输出对象e的name属性值
        System.out.println(f.get(e));
        //输出对象e2的name属性值
        System.out.println(f.get(e2));
    }

    /**
     * 章节：5.7.4 在运行时使用反射分析对象
     *
     * 通过反射在运行时设置对象属性
     *
     * 步骤：
     * 	(1) 获取对象的Class对象
     * 	(2) 获取对应的Field属性
     * 	(3) 设置该Field属性的可访问性
     * 	(4) 设置该Field属性的值（使用set(obj, val)方法）
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public void setFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Employee e = new Employee();
        e.setName("Cole Wang");
        //获取对象class类
        Class clz = e.getClass();
        //获取对象的Field
        // 不使用clz.getField()，因为其只能获取此类和父类的属性
        Field f = clz.getDeclaredField("name");
        //设置Field的可访问权限
        f.setAccessible(true);
        //设置对象的Field的值
        f.set(e, "cole");
        System.out.println(e.getName());
    }

    /**
     * 章节：5.7.5 使用反射编写泛型数组代码
     *
     * 复制数组，使用反射技术实现。适用于任何类型。如果不适用反射则无法适用于所有数组类型。
     * @param a
     * @param newLength
     * @return
     */
    public Object copyOfArray(Object a, int newLength) {
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

    /**
     * 章节：5.7.6 调用任意方法
     *
     * 测试通过反射调用方法。
     *
     */
    public void invokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Employee e = new Employee();
        //获取对象class
        Class clz = e.getClass();
        //获取对象的Method
        Method m1 = clz.getDeclaredMethod("setName", String.class);
        Method m2 = clz.getDeclaredMethod("getName");
        //通过Method.invoke调用该方法
        m1.invoke(e, "Cole");
        System.out.println(m2.invoke(e));
    }

    /////end of class
}
