package CoreJavaVolumeI._1405_synchronization;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wy on 2016-10-05.
 */
public class Bank_ReentrantLock extends AbstractBank {
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank_ReentrantLock() {
        this.bankLock = new ReentrantLock();
        this.sufficientFunds = bankLock.newCondition();

    }

    @Override
    public void transfer(int from, int to, double amount) {
        if (from >= account.size() || to >= account.size()) throw new IllegalArgumentException();
        bankLock.lock();
        try {
            // critical section(临界区)
            while (amount > account.get(from))
                sufficientFunds.await();
            System.out.println(Thread.currentThread());
            account.set(from, account.get(from) - amount);
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            account.set(to, account.get(to) + amount);
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    @Override
    public double getTotalBalance() {
        bankLock.lock();
        double sum = 0;
        try {
            for (double d : account) {
                sum += d;
            }
        } finally {
            bankLock.unlock();
        }
        return sum;
    }

    public static void main(String[] args) {
        Bank_ReentrantLock bank = new Bank_ReentrantLock();
        ArrayList<Thread> al;
        al = new ArrayList<>();
        double startTime = System.currentTimeMillis();
        for (int i = 0; i < bank.accountNum; i++) {
            al.add(new Thread(new TransferRunnalbe(bank, i, bank.accountBalance)));
        }
        for (int i = 0; i < al.size(); i++) {
            al.get(i).start();
            // 不可在此处执行join，否则第一个线程一旦wait，主线程也无法继续执行去启动新的线程，就会死锁
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


