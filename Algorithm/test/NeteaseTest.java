import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-08-09.
 */
public class NeteaseTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final Netease t = new Netease();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @org.junit.Test
    public void testGetAllAdd() throws Exception {
        t.getAllAdd(6);
        assertEquals("1+1+1+1+1+1=6\r\n" +
                "1+1+1+1+2=6\r\n" +
                "1+1+2+2=6\r\n" +
                "2+2+2=6\r\n" +
                "1+1+1+3=6\r\n" +
                "1+2+3=6\r\n" +
                "3+3=6\r\n" +
                "1+1+4=6\r\n" +
                "2+4=6\r\n" +
                "1+5=6\r\n" +
                "6=6\r\n", outContent.toString());
    }
}