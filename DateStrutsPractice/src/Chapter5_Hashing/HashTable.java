package Chapter5_Hashing;

/**
 * Created by wy on 2016-04-27 0027.
 */
public abstract class HashTable<AnyType> {
    /**
     * 装填因子，等于（已装入对象数）/（能容纳的总对象数）
     * <p>
     * 大于装填因子时，通常会执行rehash
     * </p>
     */
    protected double loadFactor;

    public abstract void makeEmpty();

    public abstract boolean contain(AnyType x);

    public abstract void insert(AnyType x);

    public abstract void remove(AnyType x);

    public abstract Object get(AnyType x);

    protected abstract void initialHashTable(int size);

    protected abstract int myhash(AnyType x);

    protected abstract void rehash();

    protected static int nextPrime(int n) {
        while (true) {
            if (isPrime(n))
                return n;
            else
                n++;
        }
    }

    ;

    protected static boolean isPrime(int n) {
        double upperBound = (int) Math.sqrt(n);
        for (int i = 2; i <= upperBound; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    ;
}
