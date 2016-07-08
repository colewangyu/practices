/**
 * Created by cole on 15/12/27.
 */
public class EqualTest {
    public static void main(String[] args) {
        float f = 0.4f;
        float g = 0.4f;
        double b = f;
        double c = g;
        System.out.println(c + " " + b);
//        equalInteger();
//        equalString();
    }

    private static void equalInteger() {
//        Integer a = 1000, b = 1000;
//        Integer c = 100, d = 100;
        Integer a = new Integer(3);
        int c = 3;
        Integer b = 3;
        System.out.println(a == b);
        System.out.println(a == b);
    }

    private static void equalString() {
        final String a = "Hello";
        final String b1 = "world";
        String b2 = "world";
        String c = "Hello world";
        String d = a + " " + b1;
        String e = a + " " + b2;
        System.out.println(d == c);
        System.out.println(e == c);
    }
    final class T {

    }
}
