package UnderstandingTheJVM._2_4_OOMErrorPractice;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 方法去OOM试验
 * 借助CGLib使方法区出现内存溢出异常
 * 
 * @version JDK1.6
 * @author wy
 *
 */
public class _2_8_JavaMethodAreaOOM {
	public static void main(String[] args) {
		while(true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				@Override
				public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
					return arg3.invokeSuper(arg0, arg2);
				}
			});
			enhancer.create();
		}
	}
	
	static class OOMObject{}
}
