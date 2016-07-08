/**
 * Created by wy on 2016-04-27 0027.
 */
public class PrimeNumber {
    private static int count;

    public static void main(String[] args) {
        count = 0;
        System.out.println(isPrimeNumber2(1234567643));
        System.out.println(isPrimeNumber2(337777111));
        System.out.println(isPrimeNumber2(7700000));
        System.out.println(isPrimeNumber2(10000097));
        System.out.println(count);
        count = 0;
        System.out.println(isPrimeNumber(1234567643));
        System.out.println(isPrimeNumber(337777111));
        System.out.println(isPrimeNumber(7700000));
        System.out.println(isPrimeNumber(10000097));
        System.out.println(count);
    }

    public static boolean isPrimeNumber(int n) {
        double upperBound = (int) Math.sqrt(n);
        for (int i = 2; i <= upperBound; i++) {
            count++;
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int isPrimeNumber2(int n) {

        int k;
        double upperBound = Math.sqrt(n);

        for (k = 2; k <= upperBound; k += 1) {
            count++;
            upperBound = n / k;
            if (n % k == 0)
                return 0;
        }

        return 1;
    }

}
