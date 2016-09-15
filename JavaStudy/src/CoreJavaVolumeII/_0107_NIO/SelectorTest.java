package CoreJavaVolumeII._0107_NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

/**
 * Created by wy on 2016-09-15.
 */
public class SelectorTest {
    public static void main(String[] args) {
        testSelector();
    }

    private static void testSelector() {
        try {
            FileInputStream in = new FileInputStream("E:\\logs\\appliction.log");
            FileChannel ch1 = in.getChannel();
            Selector selector = Selector.open();
            int readyChannels = selector.select();
            if(readyChannels == 0) return;
            Set set = selector.selectedKeys();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

