package OOMPractice;

/**
 * VM args: -Xss128k
 * JavaVM栈SOF试验
 * 
 * @version JDK1.6,JDK1.8
 * @author wy
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		new Thread().start();
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF sof = new JavaVMStackSOF();
		try {
			sof.stackLeak();
		} catch (Throwable e) {
			System.out.println("Stack length:" + sof.stackLength);
			throw e;
		}
	}
}
