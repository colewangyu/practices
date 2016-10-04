package UnderstandingTheJVM._2_4_OOMErrorPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 运行时常量池OOM实验
 * 
 * @version JDK1.6_u45
 * @author wy
 *
 */
public class _2_6_RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		//使用list保持常量池的引用，避免Full GC回收常量池
		List<String> list = new ArrayList<String>();
		//10MB的PermSize在integer范围内足够产生OOM
		int i = 0;
		while(true) {
			if(i % 100000 == 0) System.out.println(i/100000);
			list.add(String.valueOf(i++).intern());
		}
	}
}
