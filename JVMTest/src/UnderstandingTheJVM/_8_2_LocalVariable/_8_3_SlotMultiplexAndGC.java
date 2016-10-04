package UnderstandingTheJVM._8_2_LocalVariable;

/**
 * Created by wy on 2016-09-29.
 * slot复用对GC的影响
 * 设置vm参数：-verbose:gc
 */
public class _8_3_SlotMultiplexAndGC {
    public static void main(String[] args) {
        {
            byte[] bytes = new byte[64 * 1024 * 1024];
        }
//        bytes = null;
        int a = 0; // a初始化时会复用bytes的slot，前提是bytes已经不会再被使用。
        System.gc();
    }
}
