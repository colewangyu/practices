package LeetCode;

import LeetCode.Medium._11_ContainerWithMostWater;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-11-03.
 */
public class _11_ContainerWithMostWaterTest {
    _11_ContainerWithMostWater t;

    @Before
    public void setUp() throws Exception {
        t = new _11_ContainerWithMostWater();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    /*
    有效输入：
    1. 等高
    2. 中间高
    3. 两边高
    4. 递增
    5. 递减
    6. W型
    7. M型
    8. 仅有两个值
    9. 计算结果等于最大值
    10.计算结果等于最小值
    无效输入：
    1. 仅有一个值
    2. 计算结果超出范围
    3. 输入值有负数（忽略即可）
     */

    @Test
    public void testMaxArea1() throws Exception {
        assertEquals(2, t.maxArea(new int[]{1,1,1}));
    }

    @Test
    public void testMaxArea2() throws Exception {
        assertEquals(6, t.maxArea(new int[]{3,5,7}));
    }
    @Test
    public void testMaxArea3() throws Exception {
        assertEquals(6, t.maxArea(new int[]{7,5,3}));
    }
    @Test
    public void testMaxArea4() throws Exception {
        assertEquals(10, t.maxArea(new int[]{7,3,5}));
    }
    @Test
    public void testMaxArea5() throws Exception {
        assertEquals(6, t.maxArea(new int[]{3,7,5}));
    }
    @Test
    public void testMaxArea6() throws Exception {
        assertEquals(15, t.maxArea(new int[]{3,7,1,11,5}));
    }
    @Test
    public void testMaxArea7() throws Exception {
        assertEquals(14, t.maxArea(new int[]{7,5,11,1,3}));
    }
    @Test
    public void testMaxArea8() throws Exception {
        assertEquals(5, t.maxArea(new int[]{7,5}));
    }
    @Test
    public void testMaxArea9() throws Exception {
        assertEquals(0, t.maxArea(new int[]{7,0}));
    }
    @Test
    public void testMaxArea10() throws Exception {
        assertEquals(Integer.MAX_VALUE, t.maxArea(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE}));
    }
    @Test
    public void testMaxArea11() throws Exception {
        assertEquals(0, t.maxArea(new int[]{1}));
    }
    @Test
    public void testMaxArea12() throws Exception {
        assertEquals(0, t.maxArea(new int[]{Integer.MAX_VALUE,1,Integer.MAX_VALUE}));
    }
    @Test
    public void testMaxArea13() throws Exception {
        assertEquals(0, t.maxArea(new int[]{1,-1}));
    }
}