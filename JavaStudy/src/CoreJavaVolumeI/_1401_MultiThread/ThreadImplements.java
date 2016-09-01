package CoreJavaVolumeI._1401_MultiThread;

/**
 * Created by cole on 2016-05-26.
 * 多线程实现方法:实现Runnable接口
 */
public class ThreadImplements implements Runnable {
    private String name;
    private int count = 0;

    public ThreadImplements(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            count++;
            System.out.println(this.getClass().getName() + "_" + name + ":" + count);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadImplements t1 = new ThreadImplements("A");
        ThreadImplements t2 = new ThreadImplements("B");
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
