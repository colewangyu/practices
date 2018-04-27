package LeetCode.Easy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class _69_SqrtTest {
    private _69_Sqrt test;

    @Before
    public void setUp() throws Exception {
        test = new _69_Sqrt();
    }

    @Test
    public void shouldReturn2WhenInput4() throws Exception {
        assertThat(test.mySqrt(4), is(2));
    }

    @Test
    public void shouldReturn2WhenInput8() throws Exception {
        assertThat(test.mySqrt(8), is(2));
    }

    @Test
    public void shouldReturn0WhenInput0() throws Exception {
        assertThat(test.mySqrt(0), is(0));
    }

    @Test
    public void shouldReturn3WhenInput9() throws Exception {
        assertThat(test.mySqrt(9), is(3));
    }
}