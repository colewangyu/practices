package OOMPractice;

/**
 * VM Args: -Xss128k
 * !!!!!此程序可能导致windows系统假死，需要等一两分钟甚至更久才能恢复。
 * @author wy
 *
 */
public class JavaVMStackOOM {
	
	private void dontStop() {
		while(true){}
	}
	
	public void stackLeakByThread() {
		while(true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
