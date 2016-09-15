package CoreJavaVolumeII._0107_NIO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by wy on 2016-09-15.
 */
public class SocketChannelTest {
    public static void main(String[] args) {
        testSocketChannel();
    }

    private static void testSocketChannel() {
        try {
            SocketChannel socketChannel = null;
            try {
                socketChannel = SocketChannel.open();
                // 设置阻塞为false，即非阻塞
                socketChannel.configureBlocking(false);
                socketChannel.connect(new InetSocketAddress("http://113.204.136.108", 8080));

                while(!socketChannel.finishConnect()) {
                    Thread.sleep(500);
                }
                ByteBuffer buffer = ByteBuffer.allocate(128);
                int readByte = socketChannel.read(buffer);
                while(readByte != -1) {
                    buffer.flip();
                    System.out.print((char)buffer.get());
                    buffer.compact();
                }
            } finally {
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
