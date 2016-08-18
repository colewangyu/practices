package MyTest;

import javafx.util.converter.FormatStringConverter;

/**
 * Created by cole on 2016-05-12 Thursday.
 */
public class Test<T extends Comparable<? super T>> {
    public static void main(String[] args) {
        double d1 = 0.4;
        double d2 = 1;

//        d2 = d2 - 0.3 + 0.1;
        d2 = d2 - 0.99;
        d1 = d1 - 0.39;
        System.out.println(d1 + " " + d2);
        System.out.println(d1 == d2);
    }

    public T[] merge(T[] A1, T[] A2) {
        //TODO 代码未开始写。
        return null;
    }
}
