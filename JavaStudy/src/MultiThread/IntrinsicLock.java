package MultiThread;

/**
 * Created by wy on 2016-08-31.
 * 内部锁测试
 */
public class IntrinsicLock {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            Singlton singlton;

            @Override
            public void run() {
                singlton = Singlton.getInstance();
                for (int i = 0; i < 10000; i++)
                    singlton.increaseCount();
                System.out.println(singlton.count);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            Singlton singlton;

            @Override
            public void run() {
                singlton = Singlton.getInstance();
                for (int i = 0; i < 10000; i++)
                    singlton.decreaseCount();
                System.out.println(singlton.count);
            }
        });
        t1.start();
        t2.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}

class Singlton {
    public Singlton() {
    }

    private static Singlton instance;

    public static Singlton getInstance() {
        return InnerClass.instance;
    }

    static class InnerClass {
        static final Singlton instance = new Singlton();
    }

    public static int count = 0;

    public synchronized void increaseCount() {
        count++;
    }

    public synchronized void decreaseCount() {
        count--;
    }
}
