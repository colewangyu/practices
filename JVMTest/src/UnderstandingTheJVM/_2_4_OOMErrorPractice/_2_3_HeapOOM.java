package UnderstandingTheJVM._2_4_OOMErrorPractice;
import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Java堆OOM试验
 * 
 * @author wy
 *
 */
public class _2_3_HeapOOM {
	static class OOMObject {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true) {
			list.add(new OOMObject());
		}
	}
}
