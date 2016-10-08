package CoreJavaVolumeI._1410_synchronizer;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

/**
 * Created by wy on 2016-10-07.
 * CountDownLatch最重要的方法是countDown()和await()，前者主要是倒数一次，后者是等待倒数到0，如果没有到达0，就只有阻塞等待了。
 * JAVA同步器之【CountDownLatch】（不能循环使用，如果需要循环使用可以考虑使用CyclicBarrier）
 * 两种比较常规用法：
 *   1：new CountDownLatch(1);所有的线程在开始工作前需要做一些准备工作，当所有的线程都准备到位后再统一执行时有用
 *   2：new CountDownLatch(THREAD_COUNT);当所有的线程都执行完毕后，等待这些线程的其他线程才开始继续执行时有用
 */
public class CountDownLatchTest {
    private static final int THREAD_COUNT = 10;

    private static final CountDownLatch startSingal = new CountDownLatch(1);

    private static final CountDownLatch finishSingal = new CountDownLatch(THREAD_COUNT);

    private static final Logger log = Logger.getLogger(CountDownLatchTest.class.getName());

    public static void main(String[] args) {
        //开启THREAD_COUNT个线程，统统等待主线程唤醒
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        log.info(Thread.currentThread().getName() + " prepare!");
                        startSingal.await();
                        log.info(Thread.currentThread().getName() + " start!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info(Thread.currentThread().getName() + " finish!");
                    finishSingal.countDown();
                }
            }.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 主线程通过同步器唤醒等待线程
        startSingal.countDown();
        try {
            finishSingal.await();
            log.info("All Thread finish!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + " finish!");
    }

}
