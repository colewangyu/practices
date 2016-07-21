package Chapter5_Hashing;

/**
 * Created by wy on 2016-04-27.
 * <p/>
 * 二次探测
 */
public class QuadraticProbingHashTable<AnyType> extends HashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 11;
    private static final float DEFAULT_LOAD_FACTOR = 0.5f;  //装填因子，loadFactor = 散列表的元素个数 / 散列表的大小

    private float loadFactor;
    private HashEntry<AnyType>[] array; //The array of elements
    private int currentSize; // The number of occupied cells

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int tableSize) {
        this(tableSize, DEFAULT_LOAD_FACTOR);
    }

    public QuadraticProbingHashTable(int tableSize, float loadFactor) {
        initialHashTable(tableSize);
        this.loadFactor = loadFactor;
        makeEmpty();
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        currentSize = 0;
    }

    @Override
    public boolean contain(AnyType x) {
        int position = findPosition(x);
        return isActive(position);
    }

    @Override
    public void insert(AnyType x) {
        //获取可插入的位置
        int position = findPosition(x);
        //判断该位置是否可以插入
        if (isActive(position))
            return;
        //插入数据
        array[position] = new HashEntry<AnyType>(x);
        //增加hashTable大小
        currentSize++;
        //判断是否需要rehash
        if (currentSize > array.length * loadFactor) {
            rehash();
        }
    }

    @Override
    public void remove(AnyType x) {
        int position = findPosition(x);
        if (isActive(position))
            array[position].isActive = false;
    }

    @Override
    public Object get(AnyType x) {
        int position = findPosition(x);
        if (array[position] != null) {
            return array[position];
        } else {
            return null;
        }
    }

    /**
     * <b>核心方法</b><br/>
     * 获取到对象的在散列表的位置<br/>
     * 负责解决冲突
     *
     * @param x
     * @return
     */
    private int findPosition(AnyType x) {
        int offset = 1;
        int currentPos = this.myhash(x);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            //当前位置不为空(此处判断是否为null，不可判断isActive，因为如果中途的值被删除，isActive会导致停止搜索后面的冲突值，这样就无法确保后面不会有相同的对象)，
            // 且与查找的对象不相等
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    /**
     *
     */
    @Override
    protected void rehash() {
        //暂存老散列表
        HashEntry<AnyType>[] oldArray = this.array;
        //建立新表
        initialHashTable(nextPrime(oldArray.length));
        currentSize = 0;
        //添加所有老表的内容到新表中
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].element);
        }
    }

    /**
     * 初始化散列表
     *
     * @param size
     */
    @Override
    protected void initialHashTable(int size) {
        this.array = new HashEntry[size];
    }

    /**
     * 判断该位置元素是否可用
     *
     * @param position 待判断的位置
     * @return
     */
    private boolean isActive(int position) {
        return array[position] == null && array[position].isActive;
    }

    @Override
    protected int myhash(AnyType x) {
        int hashCode = x.hashCode();

        int tableSize = array.length;
        hashCode %= tableSize;
        //处理负数情况
        if (hashCode < 0) {
            hashCode += tableSize;
        }
        return hashCode;
    }

    private static class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive;  //是否可用，false表示被删除

        public HashEntry(AnyType element) {
            this(element, true);
        }

        public HashEntry(AnyType element, boolean isActive) {
            this.element = element;
            this.isActive = isActive;
        }
    }
}
