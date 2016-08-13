package Generics;

/**
 * Created by home on 2016-08-13.
 */
public class B extends A implements Comparable<B> {
    private int a;

    @Override
    public int compareTo(B o) {
        return 0;
    }
}
