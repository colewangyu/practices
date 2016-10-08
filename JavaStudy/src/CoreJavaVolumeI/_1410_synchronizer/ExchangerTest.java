package CoreJavaVolumeI._1410_synchronizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by wy on 2016-10-07.
 */
public class ExchangerTest {
    final static Exchanger<List<String>> exchanger = new Exchanger<List<String>>();

    static class Producer extends Thread {
        private Exchanger<List<String>> exchanger;

        public Producer(String name, Exchanger<List<String>> exchanger) {
            super(name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            List<String> products = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                products.add("product" + i);
            }
            try {
                List<String> result = exchanger.exchange(products);
                System.out.println("get results from consumer!");
                for (String s : result) {
                    System.out.println(s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread {
        private Exchanger<List<String>> exchanger;

        public Consumer(String name, Exchanger<List<String>> exchanger) {
            super(name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            List<String> products = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                products.add("consumed" + i);
            }
            try {
                List<String> result = exchanger.exchange(products);
                System.out.println("get products from producer!");
                for (String s : result) {
                    System.out.println(s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Producer("Producer", exchanger).start();
        new Consumer("Consumer", exchanger).start();
    }
}
