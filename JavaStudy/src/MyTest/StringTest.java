package MyTest;

/**
 * Created by wy on 2016-09-08.
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "hello";
        String[] strs = {"1"};
        change(s, strs);
        System.out.println(s + " " + strs[0]);
    }

    private static void change(String s, String[] strs) {
        s = "world";
        strs = new String[]{"2"};
    }
}
