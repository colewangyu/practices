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
        String d = a +  b1;

        //final字符串与普通常量池字符串组合，将组合字符串放入常量池（如存在则不重复放入），+号会新建立一个堆区对象，返回该对象值。
        String e = a +  b2;

        //两个final字符串组合（world相当于final），将组合字符串放入常量池（如存在则不重复放入），返回常量池地址。
        String f = a +  "world";

        System.out.println(d == c); //true
        System.out.println(e == c); //false
        System.out.println(e.intern() == c); //true
        System.out.println(f == c); //true
    }

    final class T {

    }
}
