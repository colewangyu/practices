package Generics;

/**
 * Created by home on 2016-08-13.
 */
public class Generics {
    public static void main(String[] args) {
        Generics g = new Generics();
        g.test(new B(), new C());
        g.test(new C(), new B());
    }

    public <T extends Comparable<? super T>> void test(T a1, T a2) {
        //TODO 测试如果编写a1和a2的比较
    }
}
