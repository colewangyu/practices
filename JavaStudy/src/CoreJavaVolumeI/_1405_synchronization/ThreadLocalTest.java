package CoreJavaVolumeI._1405_synchronization;

/**
 * Created by wy on 2016-10-06.
 * 学习ThreadLocal的一个例子，假设各个线程需要保存一个Integer对象的副本
 */
public class ThreadLocalTest implements Runnable {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int get() {
        return threadLocal.get();
    }

    public void add(int i) {
        threadLocal.set(threadLocal.get() + i);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            this.add(1);
            System.out.println(Thread.currentThread().getName() + " : " + this.get());
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadLocalTest()).start();
        new Thread(new ThreadLocalTest()).start();
        new Thread(new ThreadLocalTest()).start();
    }
}