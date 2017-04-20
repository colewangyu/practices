package LeetCode;

import LeetCode.Medium._8_String2Integer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cole on 2016-11-01.
 * 无效等价类
 * 1. 输入为空
 * 2. 输入为""
 * 3. 输入包含非数字
 * 4. 输入超出整形范围
 * 5. 输入只有符号
 * 有效等价类
 * 1. 输入正数(可以带正号,也可以省略正号)
 * 2. 输入负数(必须带负号)
 * 3. 输入0
 * 4. 输入为边界值
 * 5. 输入前面一位或多位为0
 * 6. 输入前面有一个或多个空格
 */

public class _8_String2IntegerTest {
    _8_String2Integer t;

    @Before
    public void setUp() throws Exception {
        t = new _8_String2Integer();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testMyAtoi1() throws Exception {
        assertEquals(123, t.myAtoi("123"));
        assertEquals(123, t.myAtoi("+123"));
    }

    @Test
    public void testMyAtoi2() throws Exception {
        assertEquals(-123, t.myAtoi("-123"));
    }

    @Test
    public void testMyAtoi3() throws Exception {
        assertEquals(0, t.myAtoi("0"));
    }

    @Test
    public void testMyAtoi4() throws Exception {
        assertEquals(12, t.myAtoi("0012"));
    }

    @Test
    public void testMyAtoi5() throws Exception {
        assertEquals(2147483647, t.myAtoi("2147483647"));
    }

    @Test
    public void testMyAtoi6() throws Exception {
        assertEquals(-2147483648, t.myAtoi("-2147483648"));
    }

    @Test
    public void testMyAtoi9() throws Exception {
        assertEquals(0, t.myAtoi(null));
    }

    @Test
    public void testMyAtoi10() throws Exception {
        assertEquals(-1, t.myAtoi("-01a2"));
    }

    @Test
    public void testMyAtoi11() throws Exception {
        assertEquals(2147483647, t.myAtoi("2147483648"));
    }

    @Test
    public void testMyAtoi12() throws Exception {
        assertEquals(123, t.myAtoi("   123"));
    }

    @Test
    public void testMyAtoi13() throws Exception {
        assertEquals(12, t.myAtoi(" 12 34"));
    }

    @Test
    public void testMyAtoi14() throws Exception {
        assertEquals(0, t.myAtoi(" +"));
    }

    @Test
    public void testMyAtoi15() throws Exception {
        assertEquals(0, t.myAtoi(""));
    }

    @Test
    public void testMyAtoi16() throws Exception {
        assertEquals(-2147483648, t.myAtoi("-2147483649"));
    }

}