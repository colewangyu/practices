package CoreJavaVolumeI._1405_synchronization;

import java.util.ArrayList;

/**
 * Created by wy on 2016-10-05.
 */
public class TransferRunnalbe implements Runnable {

    private static double DELAY = 100;

    private AbstractBank bank;
    private ArrayList<Double> acount;
    private int thisAcount;
    private double balance;

    public TransferRunnalbe(AbstractBank bank, int thisAcount, double balance) {
        this.bank = bank;
        this.acount = bank.getAcount();
        this.thisAcount = thisAcount;
        this.balance = balance;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int toAccount = (int) (acount.size() * Math.random());
                double amount = balance * Math.random();
                bank.transfer(thisAcount, toAccount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
