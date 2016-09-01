package CoreJavaVolumeI._1401_MultiThread;

/**
 * Created by cole on 2016-05-26.
 * 多线程实现方法:继承Thread类
 */
public class ThreadExtends extends Thread {
    private String name;
    private int count = 0;
    public ThreadExtends(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            count++;
            System.out.println(this.getClass().getName() + "_" + this.name + ":" + count);
            try {
                sleep((long) (Math.random() * 1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadExtends t1 = new ThreadExtends("A");
        ThreadExtends t2 = new ThreadExtends("B");
        t1.start();
        t2.start();
    }
}
