package CoreJavaVolumeI._1405_synchronization;

import java.util.Objects;

/**
 * Created by wy on 2016-10-06.
 * 模拟suspend方法造成死锁的情况
 */
public class SuspendDeadLockTest {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread t1 = new Thread(new SuspendRunner(obj));
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (obj) {
            System.out.println(Thread.currentThread() + "get obj lock!");
        }
        // resume方法无法执行
        t1.resume();
    }
}

class SuspendRunner implements Runnable {

    private Object obj;

    public SuspendRunner(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            System.out.println(Thread.currentThread() + "get obj lock!");
            Thread.currentThread().suspend();
        }
    }
}