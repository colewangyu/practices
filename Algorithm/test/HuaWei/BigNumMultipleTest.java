package HuaWei;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by cole on 2016-11-01.
 */
public class BigNumMultipleTest {
    BigNumMultiple t;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        t = new BigNumMultiple();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        t = null;
        System.setOut(null);
        System.setIn(null);
    }

    @Test
    public void testMain1() throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream("123456789012345 10\n".getBytes());
        System.setIn(bis);
        t.main(null);
        assertEquals("1234567890123450\n", outContent.toString());
    }
}