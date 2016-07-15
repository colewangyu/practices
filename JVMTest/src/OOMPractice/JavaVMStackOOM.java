package OOMPractice;

/**
 * VM Args: -Xss2m
 * Java虚拟机栈OOM试验
 * 
 * !!!!!此程序会导致windows系统假死，需重启才能恢复
 * !!!!!此程序会导致MacOS CPU占用率100%，从而奇卡无比。
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
