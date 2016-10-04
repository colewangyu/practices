package UnderstandingTheJVM._8_2_LocalVariable;

/**
 * Created by wy on 2016-09-29.
 */
public class _8_3_SlotMultiplexAndGC {
    public static void main(String[] args) {
        byte[] bytes = new byte[64 * 1024 * 1024];
//        bytes = null;
        System.gc();
    }
}
