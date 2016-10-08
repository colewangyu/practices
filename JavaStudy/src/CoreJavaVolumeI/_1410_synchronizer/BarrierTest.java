package CoreJavaVolumeI._1410_synchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by wy on 2016-10-07.
 * JAVA同步器之Barrier(能够循环使用，当计数器增加到Barrier的初始化计数器之后马上会被置为0为下一次循环使用做准备)
 * Barrier能够为指定的一个或多个（一般为多个）线程设置一道屏障，只有当所有的线程都到达该屏障后才能一起冲过该屏障继续其他任务
 * 常规用法：
 * 1. new CyclicBarrier(ThreadCount)来进行初始化
 * 2. new CyclicBarrier(ThreadCount,RunableAction)，当初始化数量的线程都调用了await()方法后触发RunableAction线程。
 * 3. new CyclicBarrier(ThreadCount+1)的Barrier在前置线程未执行完成时一直阻塞一个或多个后续线程，这一点类似于CountDownLatch
 */
public class BarrierTest {
    private static final int THREAD_COUNT = 10;
    private static final CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT + 1, new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("All task are prepared or finished!!");
        }
    });

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread("Task " + i) {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " prepare!");
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " finish!");
                }
            }.start();
        }
        barrier.await();
        // --------------开始准备循环使用--------------
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread("Task " + i) {
                public void run() {
                    // do something
                    System.out.println(Thread.currentThread().getName()
                            + " finished!!");
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        barrier.await();
    }
}
