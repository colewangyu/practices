package UnderstandingTheJVM._2_4_OOMErrorPractice;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * 直接内存OOM试验
 * 
 * @version JDK1.6,JDK1.8
 * @author wy
 *
 */
public class _2_9_DirectMemoryOOM {
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while(true) {
			unsafe.allocateMemory(_1MB);
		}
	}
}
