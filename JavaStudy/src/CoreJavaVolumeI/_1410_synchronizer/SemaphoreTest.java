package CoreJavaVolumeI._1410_synchronizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by wy on 2016-10-07.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3, true);
        for (int i = 0; i < 10; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "已经进入，当前有"
                            + (3 - semaphore.availablePermits()) + "线程并发");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "即将离开");
                    semaphore.release();
                }
            });
        }
        // 关闭线程池
        es.shutdown();
    }

   /* private static final int MAX_AVAILABLE = 5;
    // true表示按照顺序来获取
    private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
        // 获取信号量
        semaphore.acquire();
        // 获取到信号量后，就可以执行对应操作（此处为获取对应的对象，标记为使用状态）
        return getNextAvailableItem();
    }

    public void putItem(Object obj) {
        // 条件满足后，就释放信号量（此处为将对象标记为未使用状态）
        if (markAsUnused(obj))
            semaphore.release();
    }

    *//* 非信号量必要，只是用于演示 *//*
    protected Object[] items = new Object[]{"aa", "bb", "cc", "dd"};
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null;
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (item.equals(items[i])) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }*/

}
