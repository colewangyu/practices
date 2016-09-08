package DesignPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wy on 2016-08-30.
 */
public class DynamicProxy {
    public static void main(String[] args) {
        RealSubject real = new RealSubject();
        Subject proxyDinamic = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before");
                        method.invoke(real, args);
                        System.out.println("after");
                        return null;
                    }
                });
        proxyDinamic.doSomething();
    }
}