package MultiThread;

/**
 * Created by wy on 2016-08-31.
 * 内部锁测试
 */
public class IntrinsicLock {
    public static void main(String[] args) {
//        testObjLock();
        testClassLock();
    }

    private static void testObjLock() {
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
    }

    private static void testClassLock() {
        final Multiton o1 = new Multiton();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                o1.increaseCount();
            }
        });
        final Multiton o2 = new Multiton();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                o2.increaseCount();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Multiton.count);
    }
}

class Singlton {
    private Singlton() {
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

class Multiton {
    public Multiton() {
    }

    public static int count = 0;

    public void increaseCount() {
        synchronized (this) {
            for (int i = 0; i < 50000; i++)
                count++;
        }
    }
}
