package CoreJavaVolumeI._1405_synchronization;

import java.util.ArrayList;

/**
 * Created by wy on 2016-10-05.
 */
public abstract class AbstractBank {
    protected final int accountNum = 10;
    protected final double accountBalance = 1000d;
    protected final ArrayList<Double> account;

    public AbstractBank() {
        this.account = new ArrayList<Double>();
        for(int i = 0; i < accountNum; i++) {
            account.add(i, accountBalance);
        }
    }

    public ArrayList<Double> getAcount() {
        return account;
    }

    public abstract double getTotalBalance();

    public abstract void transfer(int from, int to, double amount);
}
