package CoreJavaVolumeII._0101_Stream;

import java.io.*;

/**
 * Created by wy on 2016-07-27.
 */
public class Stream {
    /**
     * 字节读取
     */
    public static void inputStreamTest() {
        //InputStream实现类——FileInputStream
        FileInputStream is = null;
        try {
            try {
                is = new FileInputStream("C:\\Users\\wy\\Desktop\\java0JavaStudyLog.1");
                byte[] b = new byte[500];
                int len;
                while((len = is.read(b)) >= 0) {
                    System.out.println(new String(b, 0, len));
                }
            } finally {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //InputStream实现类——System.in(预定义对象)
//        try {
//            byte[] b = new byte[6];
//            System.out.println(System.in.read(b));
//            System.out.println(new String(b, "UTF-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 字节写入
     */
    public static void outputStreamTest() {
        //OutputStream实现类——FileOutputStream
        FileOutputStream fos = null;
        try {
            try {
                fos = new FileOutputStream("C:\\Users\\wy\\Desktop\\javaOutputTest.txt");
                fos.write("你好".getBytes());
                fos.write(1);
                //将缓存写入
                fos.flush();
            } finally {
                //关闭会自动执行flush()
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符读取
     */
    public static void readerTest() {
        FileReader fr = null;
        try {
            try {
                fr = new FileReader("C:\\Users\\wy\\Desktop\\java0JavaStudyLog.1");
                char[] b = new char[100];
                int len;
                while((len = fr.read(b)) >= 0) {
                    System.out.println(new String(b,0,len));
                }
            } finally {
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符写入
     */
    public static void writerTest() {
        FileWriter fw = null;
        try {
            try {
                fw = new FileWriter("C:\\Users\\wy\\Desktop\\javaWriterTest.txt");
                fw.write("我们是祖国的花朵，\n用青春拥抱未来！");
            } finally {
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
