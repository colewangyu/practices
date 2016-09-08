package MultiThread;

/**
 * Created by wy on 2016-09-09.
 */
public class ThreadController {
    public static void main(String[] args) throws InterruptedException {
        Join join = new Join();
        Thread t1 = new Thread(join, "A");
        t1.start();
        t1.join();
        System.out.println(join.count);
        System.out.println(Thread.currentThread().getName() + " 运行结束");
    }
}

class Join implements Runnable {
    public int count = 0;
    @Override
    public void run() {
        for(int i = 0; i < 5000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " 运行结束");
    }
}
