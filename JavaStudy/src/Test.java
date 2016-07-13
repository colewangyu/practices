import javafx.util.converter.FormatStringConverter;

/**
 * Created by cole on 2016-05-12 Thursday.
 */
public class Test {
    public static void main(String[] args) {
        double d1 = 0.4;
        double d2 = 1;

//        d2 = d2 - 0.3 + 0.1;
        d2 = d2 - 0.99;
        d1 = d1 - 0.39;
        System.out.println(d1 + " " + d2);
        System.out.println(d1 == d2);
    }
}
