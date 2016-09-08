package MyTest;//import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by home on 2015-09-07.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep)
                    Toolkit.getDefaultToolkit().beep();
                Thread.currentThread().interrupt();
            }
        };
        t.schedule(tt, 2500);
    }

    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("At the tone, the time is " + now);
            if (beep)
                Toolkit.getDefaultToolkit().beep();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        TalkingClock tc = new TalkingClock(2500, true);
        //开启计时器线程
        tc.start();
        for(int i = 1 ; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

