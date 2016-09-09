package MultiThread;

/**
 * Created by wy on 2016-09-09.
 */
public class ThreadPrintABC {
    public static void main(String[] args) {
        Object blockA = new Object();
        Object blockB = new Object();
        Object blockC = new Object();
        MyThreadPrint t1 = new MyThreadPrint("A", blockC, blockA);
        MyThreadPrint t2 = new MyThreadPrint("B", blockA, blockB);
        MyThreadPrint t3 = new MyThreadPrint("C", blockB, blockC);
        try {
            new Thread(t1).start();
            Thread.sleep(100);
            new Thread(t2).start();
            Thread.sleep(100);
            new Thread(t3).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadPrint implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    public MyThreadPrint(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 5;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    count--;
                    System.out.print( this.name);
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
