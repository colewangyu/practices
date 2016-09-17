package MultiThread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wy on 2016-09-16.
 */
public class JavaLock {
    public static void main(String[] args) {

    }
}

/**
 * 自旋锁
 */
class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock(){
        Thread cur = Thread.currentThread();
        while(!sign.compareAndSet(null, cur)) {
            // 一直循环执行CAS
        }
    }

    public void unlock() {
        Thread cur = Thread.currentThread();
        sign.compareAndSet(cur, null);
    }
}
