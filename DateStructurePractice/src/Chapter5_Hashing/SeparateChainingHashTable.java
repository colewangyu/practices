package Chapter5_Hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * <p><b>分离链接哈希表</b></p>
 * <p>
 *     【说明】解决散列值冲突的方法之一<br/>
 *     在散列表的每个值上存一个双向链表{@Link java.util.LinkedList}，将重复的值放入这个双向链表中，一次解决冲突。<br/>
 *     <b>装填因子（LoadFactor）建议设置为1.0</b>
 *  </p>
 *
 * <p>【优点】</p>
 * <p>【缺点】使用链表，在给新单元分配地址时需要时间而导致算法速度减慢</p>
 * Created by wy on 2016-04-22.
 */
public class SeparateChainingHashTable<AnyType> extends HashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 103;
    private static final float  DEFAULT_LOAD_FACTOR = 1.0f;  //装填因子，loadFactor = 散列表的元素个数 / 散列表的大小

    private float loadFactor;
    private List<AnyType>[] theLists; //散列表
    private int currentSize;  //当前大小

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int tableSize) {
        this(tableSize, DEFAULT_LOAD_FACTOR);
    }

    public SeparateChainingHashTable(int tableSize, float loadFactor) {
        initialHashTable(tableSize);
        currentSize = 0;
        this.loadFactor = loadFactor;
    }

    public void makeEmpty() {
        for(int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    @Override
    public boolean contain(AnyType x) {
        return false;
    }

    /**
     * 增
     * @param x
     */
    @Override
    public void insert(AnyType x) {
        List<AnyType> tmpList = theLists[myhash(x)];
        if(!tmpList.contains(x)) {
            tmpList.add(x);
            if(++currentSize > theLists.length * loadFactor) {
                rehash();
            }
        }
    }

    /**
     * 删
     * @param x
     */
    @Override
    public void remove(AnyType x) {
        List<AnyType> tmpList = theLists[myhash(x)];
        tmpList.remove(x);
    }

    /**
     * 查
     * @param x
     */
    @Override
    public Object get(AnyType x) {
        int hashCode = myhash(x);
        List<AnyType> tmpLink = theLists[hashCode];
        int index = tmpLink.indexOf(x);
        if(index >= 0) {
            return tmpLink.get(index);
        } else {
            return null;
        }
    }

    @Override
    protected void initialHashTable(int size) {
        theLists = new List[size];
        for(int i = 0; i < size; i++) {
            theLists[i] = new LinkedList<AnyType>();
        }
    }

    @Override
    protected void rehash() {
        //暂存旧的散列表
        List<AnyType>[] oldLists = theLists;
        //建立新表
        initialHashTable(nextPrime(oldLists.length * 2));
        currentSize = 0;
        //添加所有老表的内容到新表中
        for(int i = 0; i < oldLists.length; i++) {
            for(AnyType item : oldLists[i]) {
                insert(item);
            }
        }
    }

    /**
     * 计算散列值（hashCode），方法与{@link Hash}中的hash3方法一致
     * @param x
     * @return
     */
    protected int myhash(AnyType x) {
        int hashCode = x.hashCode();

        int tableSize = theLists.length;
        hashCode %= tableSize;
        //处理负数情况
        if(hashCode < 0) {
            hashCode += tableSize;
        }
        return hashCode;
    }
}
