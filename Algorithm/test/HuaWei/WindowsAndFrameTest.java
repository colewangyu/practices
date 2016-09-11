package HuaWei;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-09-11.
 */
public class WindowsAndFrameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


    @Test
    public void testDoWindowsAndFrame() throws Exception {
        WindowsAndFrame.doWindowsAndFrame();
        assertEquals("1,3", outContent.toString());

    }
}