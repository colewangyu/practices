package Chapter2_AlgorithmAnalysis;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-09-05.
 */
public class _0203_GCDTest {

    @Test
    public void testGetGCD1() throws Exception {
        assertEquals(new BigInteger("0"), _0203_GCD.getGCD1(new BigInteger("0"),new BigInteger("0")));
        assertEquals(new BigInteger("4"), _0203_GCD.getGCD1(new BigInteger("0"),new BigInteger("4")));
        assertEquals(new BigInteger("2"), _0203_GCD.getGCD1(new BigInteger("2"),new BigInteger("4")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD1(new BigInteger("1"),new BigInteger("3")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD1(new BigInteger("7"),new BigInteger("3")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD1(new BigInteger("3"),new BigInteger("7")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD1(new BigInteger("300000"),new BigInteger("1")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD1(new BigInteger("30000000"),new BigInteger("1253")));
    }

    @Test
    public void testGetGCD2() throws Exception {
        assertEquals(new BigInteger("0"), _0203_GCD.getGCD2(new BigInteger("0"),new BigInteger("0")));
        assertEquals(new BigInteger("4"), _0203_GCD.getGCD2(new BigInteger("0"),new BigInteger("4")));
        assertEquals(new BigInteger("2"), _0203_GCD.getGCD2(new BigInteger("2"),new BigInteger("4")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD2(new BigInteger("1"),new BigInteger("3")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD2(new BigInteger("7"),new BigInteger("3")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD2(new BigInteger("3"),new BigInteger("7")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD2(new BigInteger("300000"),new BigInteger("1")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD2(new BigInteger("30000000"),new BigInteger("1253")));
    }

    @Test
    public void testGetGCD3() throws Exception {
        assertEquals(new BigInteger("0"), _0203_GCD.getGCD3(new BigInteger("0"),new BigInteger("0")));
        assertEquals(new BigInteger("4"), _0203_GCD.getGCD3(new BigInteger("0"),new BigInteger("4")));
        assertEquals(new BigInteger("2"), _0203_GCD.getGCD3(new BigInteger("2"),new BigInteger("4")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD3(new BigInteger("1"),new BigInteger("3")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD3(new BigInteger("7"),new BigInteger("3")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD3(new BigInteger("3"),new BigInteger("7")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD2(new BigInteger("300000"),new BigInteger("1")));
        assertEquals(new BigInteger("1"), _0203_GCD.getGCD2(new BigInteger("30000000"),new BigInteger("1253")));
    }
}