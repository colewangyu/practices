package Chapter5_Hashing;

import java.util.HashMap;

/**
 * Created by wy on 2016-04-20.
 */
public class Hash {
    /**
     * <p><b>简单的散列函数</b></p>
     * <p>【说明】</p>
     * <p>【优点】速度快，实现简单</p>
     * <p>【缺点】tableSize设置得很大的时候，会浪费很多空间</p>
     * @param key 待散列的字符串
     * @param tableSize 散列表的大小，即桶的大小(bucket)
     * @return 散列值
     */
    public static int hashCode1(String key, int tableSize) {
        int hashVal = 0;
        for(int i = 0; i < key.length(); i++) {
            hashVal += key.charAt(i);
        }
        return hashVal % tableSize;
    }

    /**
     * <p><b>不太好的散列函数例子</b></p>
     * <p>【说明】</p>
     * <p>【优点】速度快，实现简单</p>
     * <p>【缺点】散列不均匀，导致空间利用与较低</p>
     * @param key 待散列的字符串
     * @param tableSize 散列表的大小，即桶的大小(bucket)
     * @return 散列值
     */
    public static int hashCode2(String key, int tableSize) {
        return (key.charAt(0) + 27 * key.charAt(1) + 729 * key.charAt(2)) % tableSize;
    }

    /**
     * <p><b>较好的散列函数</b></p>
     * <p>【说明】<b>常用的散列函数</b><br/>根据Horner法则计算一个37的多项式函数，公式：Hk = K0 + 37 * (K1 + 37 * K2)</p>
     * <p>【优点】速度快，实现简单</p>
     * <p>【缺点】允许溢出，所以需要额外处理溢出</p>
     * @param key 待散列的字符串
     * @param tableSize 散列表的大小，即桶的大小(bucket)
     * @return 散列值
     */
    public static int hashCode3(String key, int tableSize) {
        int hashCode = 0;

        for(int i = 0; i < key.length(); i++ ) {
            hashCode = 37 * hashCode + key.charAt(i);
        }

        hashCode %= tableSize;
        //hashCode可能溢出
        if(hashCode < 0) {
            hashCode += tableSize;
        }

        return hashCode;
    }
}
