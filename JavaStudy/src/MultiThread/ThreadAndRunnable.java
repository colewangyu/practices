package MultiThread;

/**
 * Created by wy on 2016-09-08.
 */
public class ThreadAndRunnable {
    public static void main(String[] args) {
        MyThread myT = new MyThread();
        new Thread(myT, "A").start();
        new Thread(myT, "B").start();
        new Thread(myT, "C").start();
        try {
            myT.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + myT.count);

        MyRunnable myR = new MyRunnable();
        new Thread(myR, "D").start();
        new Thread(myR, "E").start();
        new Thread(myR, "F").start();

        System.out.println(Thread.currentThread().getName() + myR.count);
    }
}

class MyThread extends Thread {
    public int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            count++;
        }
    }
}

class MyRunnable implements Runnable {
    public int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            count++;
        }
    }
}
