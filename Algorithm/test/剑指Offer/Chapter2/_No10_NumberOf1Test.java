package 剑指Offer.Chapter2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-09-01.
 */
public class _No10_NumberOf1Test {

    @Test
    public void testNumberOf1() throws Exception {
        // 正数
        assertEquals(1, _No10_NumberOf1.numberOf1(1));
        assertEquals(2, _No10_NumberOf1.numberOf1(9));
        assertEquals(31, _No10_NumberOf1.numberOf1(Integer.MAX_VALUE));

        // 负数
        assertEquals(32, _No10_NumberOf1.numberOf1(-1));
        assertEquals(31, _No10_NumberOf1.numberOf1(-3));
        assertEquals(1, _No10_NumberOf1.numberOf1(Integer.MIN_VALUE));

        // 0
        assertEquals(0, _No10_NumberOf1.numberOf1(+0));
        assertEquals(0, _No10_NumberOf1.numberOf1(-0));
    }
}