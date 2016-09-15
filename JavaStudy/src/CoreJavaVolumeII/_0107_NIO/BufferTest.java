package CoreJavaVolumeII._0107_NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wy on 2016-09-15.
 */
public class BufferTest {
    public static void main(String[] args) {
        testBuffer();
    }

    private static void testBuffer() {
        try {
            RandomAccessFile file = new RandomAccessFile(".gitignore", "rw");
            FileChannel fileChannel = file.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(64);
            // 读取fileChannel的数据，写入到buffer中
            int bytesRead = fileChannel.read(buffer);
            while(bytesRead != -1) {
                // 由读取转换为写入
                buffer.flip();
                while(buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                // 清理已经读取的，准备下一次写入。
                buffer.compact();
                bytesRead = fileChannel.read(buffer);
            }
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
