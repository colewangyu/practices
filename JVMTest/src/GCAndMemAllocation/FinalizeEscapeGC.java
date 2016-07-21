package GCAndMemAllocation;

/**
 * 测试finalize方法被System.gc()调用。
 * 对象的finalize方法仅能被调用一次，该方法必须被对象重写。
 * 
 * @version JDK1.6, JDK1.8
 * @author wy
 *
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOCK =null;
	
	public void isAlive(){
		System.out.println("Yes! I am alive :)");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Finalize method executed!");
		//自我救赎
		FinalizeEscapeGC.SAVE_HOCK = this;
	}
	
	public static void main(String[] args) throws InterruptedException {
		SAVE_HOCK = new FinalizeEscapeGC();
		
		SAVE_HOCK = null;
		//gc()会执行finalize()。
		System.gc();
		//finalize()优先级比较低，所以需要让主线程暂停0.5s。
		Thread.sleep(500);
		if(SAVE_HOCK != null) {
			SAVE_HOCK.isAlive();
		} else {
			System.out.println("No, I am dead :(");
		}
		
		//第二段代码与第一段完全一致
		SAVE_HOCK = null;
		//同一个对象只能被调用一次finalize()，此处自我救赎失败。
		System.gc();
		Thread.sleep(500);
		if(SAVE_HOCK != null) {
			SAVE_HOCK.isAlive();
		} else {
			System.out.println("No, I am dead :(");
		}
	}
}
