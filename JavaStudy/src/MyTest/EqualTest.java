package MyTest;

/**
 * Created by cole on 15/12/27.
 */
public class EqualTest {
    public static void main(String[] args) {
//        equalInteger();
        equalString();
    }

    private static void equalInteger() {
        //使用new的对象
        Integer a = 1000, b = 1000;
        //-128到127使用缓存的对象
        Integer c = 100, d = 100;
        System.out.println(a == b); //false
        System.out.println(c == d); //true

        Integer i = 127;
        Integer j = 127;
        // -128到127在自动装箱时使用缓存，因此对象内容和地址均相同(new的地址不相同)
        System.out.println(i == j); // true
        i = 128;
        j = 128;
        System.out.println(i == j); // false

        Integer i1 = 128;
        int j1 = 128;
        // 与基本类型比较，对象会被自动拆箱，因此会直接比较数值，而不是地址。
        System.out.println(i1 == j1); // true

        Integer i2 = new Integer(128);
        int j2 = 128;
        // 与基本类型比较，对象会被自动拆箱，因此会直接比较数值，而不是地址。
        System.out.println(i2 == j2); // true
        // 会对j2进行装箱，
        System.out.println(i2 == new Integer(j2)); //false

        Integer i3 = new Integer(1);
        Integer j3 = new Integer(1);
        // 两个对象==会比较地址，因为new会生成新地址，所以为false
        System.out.println(i3 == j3); // false
    }

    /**
     * 两个final字符串相加，不生成新的堆区对象（直接与字符串相加而不是与变量相加，字符串相当于final类型）
     * 普通字符串相加，会生成新的堆区对象
     */
    private static void equalString() {
        //final关键字，编译期放入常量池。
        final String a = "Hello";
        final String b1 = "world";
        //先把字符串放入常量池（如存在则不重复放入），返回常量池地址。
        String b2 = "world";
        String c = "Helloworld";

        //两个final字符串的组合，将组合字符串放入常量池（如存在则不重复放入），返回常量池地址。
        String d = a + b1;

        //final字符串与普通常量池字符串组合，将组合字符串放入常量池（如存在则不重复放入），+号会新建立一个堆区对象，返回该对象值。
        String e = a + b2;

        //两个final字符串组合（world相当于final），将组合字符串放入常量池（如存在则不重复放入），返回常量池地址。
        String f = a + "world";

        System.out.println(d == c); //true
        System.out.println(e == c); //false
        System.out.println(e.intern() == c); //true
        System.out.println(f == c); //true
    }
}
