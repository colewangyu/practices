package UnderstandingTheJVM._2_4_OOMErrorPractice;

/**
 * VM Args: -Xss1000m
 * Java虚拟机栈OOM试验
 * 
 * !!!!!此程序会导致windows系统假死，需重启才能恢复
 * !!!!!此程序会导致MacOS CPU占用率100%，从而奇卡无比。
 * @author wy
 *
 */
public class _2_4_JavaVMStackOOM {
	
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
		_2_4_JavaVMStackOOM oom = new _2_4_JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
