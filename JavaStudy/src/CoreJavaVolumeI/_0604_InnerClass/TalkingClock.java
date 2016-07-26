package CoreJavaVolumeI._0604_InnerClass;

import CoreJavaVolumeI._0507_Reflect.Reflect;

import CoreJavaVolumeI._0507_Reflect.Reflect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 * Created by wy on 2016-07-25.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock() {
    }

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }
    public void start(int interval, boolean beep) {
        //局部内部类
        class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("响铃时间为：" + now);
                //beep引用TalkingClok的beep(使用内部类访问对象属性)
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public void start() {
        //匿名内部类
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("响铃时间为：" + now);
                //beep引用TalkingClok的beep(使用内部类访问对象属性)
                if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
                System.out.println(this.getClass());
            }
        };
        Timer t = new Timer(TalkingClock.this.interval, listener);
        t.start();
    }

    public static void main(String[] args) {
       /* TalkingClock t = new TalkingClock();
        t.start(1000, true);
        JOptionPane.showMessageDialog(null, "退出程序？");
        System.exit(0);*/

        TalkingClock t2 = new TalkingClock(1000, true);
        //查看内部类中编译后的方法和属性
        Reflect r = new Reflect();
        try {
            r.getDeclaredMethods("CoreJavaVolumeI._0604_InnerClass.TalkingClock");
            r.getDeclaredFields("CoreJavaVolumeI._0604_InnerClass.TalkingClock");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        t2.start();
        JOptionPane.showMessageDialog(null, "退出程序？");
        System.exit(0);
    }
}
