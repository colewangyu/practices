import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-11-29.
 */
public class RandomArrayWithoutRepeatTest {
    RandomArrayWithoutRepeat t;

    @Before
    public void setUp() throws Exception {
        t = new RandomArrayWithoutRepeat();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static boolean arrayEquals(int[] a, int[] b) {
        // 同一个类
        if (a == b) return true;
        // 不同长度
        if (a.length != b.length) return false;
        // 同时为null
        if (a == null && b == null) return true;
        // 某一个为null
        if (a == null || b == null) return false;

        // 一次比较
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    @Test
    public void printNoRepeat1() throws Exception {
        assertTrue(arrayEquals(new int[]{1, 2, 3}, t.printNoRepeat(new int[]{1, 2, 3, 3}, 3)));
    }

    @Test
    public void printNoRepeat2() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        t.printNoRepeat(new int[]{1, 2, 3, 3}, 4);
    }

    @Test
    public void printNoRepeat3() throws Exception {
        assertTrue(arrayEquals(new int[]{1}, t.printNoRepeat(new int[]{1}, 1)));
    }

    @Test
    public void printNoRepeat4() throws Exception {
        assertTrue(arrayEquals(new int[]{1, 2, 3}, t.printNoRepeat(new int[]{1, 3, 2, 1}, 3)));
    }

    @Test
    public void printNoRepeat5() throws Exception {
        assertTrue(arrayEquals(new int[]{1, 2, 3, 4}, t.printNoRepeat(new int[]{1, 2, 3, 4}, 4)));
    }

    @Test
    public void printNoRepeat6() throws Exception {
        assertTrue(arrayEquals(new int[]{1, 2}, t.printNoRepeat(new int[]{1, 2, 3, 4}, 2)));
    }

}