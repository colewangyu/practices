package CoreJavaVolumeI._1405_synchronization;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wy on 2016-10-05.
 */
public class Bank_SynchronizedLock extends AbstractBank {

    @Override
    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double d : account)
            sum += d;
        return sum;
    }

    @Override
    public synchronized void transfer(int from, int to, double amount) {

        if (account.get(from) < amount)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.print(Thread.currentThread());
        account.set(from, account.get(from) - amount);
        System.out.printf("%10.2f from %d to %d ", amount, from, to);
        account.set(to, account.get(to) + amount);
        System.out.printf("Totle Balance: %10.2f \n", getTotalBalance());
        this.notifyAll();
    }

    public static void main(String[] args) {
        Bank_SynchronizedLock bank = new Bank_SynchronizedLock();
        ArrayList<Thread> al = new ArrayList<>();
        double startTime = System.currentTimeMillis();
        for (int i = 0; i < bank.accountNum; i++) {
            al.add(new Thread(new TransferRunnalbe(bank, i, bank.accountBalance)));
        }
        for (int i = 0; i < al.size(); i++) {
            al.get(i).start();
        }
        for (int i = 0; i < al.size(); i++) {
            try {
                al.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        double endTime = System.currentTimeMillis();
        System.out.printf("Running time: %10.3f", endTime - startTime);
    }
}
