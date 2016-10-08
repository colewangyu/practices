package CoreJavaVolumeI._1410_synchronizer;

import java.util.concurrent.Semaphore;

/**
 * Created by wy on 2016-10-07.
 * 对同步队列进行实现
 */
public class SynchronousQueueRealize {
    public static void main(String[] args) {
        
    }
}
/**
 * 阻塞方法实现同步队列（这是一种不好的实现）
 * 因为每个操作都会上锁，存在较多上下文切换，因此开销较大。
 * 另外存在一种情况，A线程持有B线程需要的锁，但是B线程优先级较高，
 * 因此A线程难以获得运行机会来释放锁，导致效率更低。
 */
class BlockSynchronousQueue<E> {
    boolean putting = false;
    E item = null;

    public synchronized E take() throws InterruptedException {
        while (item == null)
            wait();
        E e = item;
        item = null;
        notifyAll();
        return e;
    }

    public synchronized void put(E e) throws InterruptedException {
        if(e == null) return;
        while(putting)
            wait();
        putting = true;
        item = e;
        notifyAll();
        while(item != null)
            wait();
        putting = false;
        notifyAll();
    }
}

/**
 * 经典同步队列实现采用了三个信号量
 */
class SemaphoreSynchronousQueue<E> {
    E item = null;
    Semaphore sync = new Semaphore(0);
    Semaphore send = new Semaphore(1);
    Semaphore rece = new Semaphore(0);

    public E take() throws InterruptedException {
        rece.acquire();
        E x = item;
        sync.release();
        send.release();
        return x;
    }

    public void put(E x) throws InterruptedException {
        send.acquire();
        item = x;
        rece.release();
        sync.acquire();
    }
}
