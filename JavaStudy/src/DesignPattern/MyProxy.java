package DesignPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wy on 2016-08-30.
 */
public class MyProxy {
    public static void main(String[] args) {
        Subject real = new RealSubject();
        ProxyHandler proxy = new ProxyHandler(real);
        try {
            proxy.invoke(null, real.getClass().getMethod("doSomething"), null);
            proxy.invoke(null, real.getClass().getMethod("doSomething", String.class, String[].class), new Object[]{"str1",new String[]{"str[0]", "str[1]"}});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

interface Subject {
    public void doSomething();
    public void doSomething(String arg1, String[] arg2);
}

class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("call doSomething()");
    }

    @Override
    public void doSomething(String arg1, String[] arg2) {
        System.out.println("call doSomething() " + arg1 + " " + arg2[0]);
    }
}

class ProxyHandler implements InvocationHandler {
    private Subject proxied;

    public ProxyHandler(Subject proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy method before");
        method.invoke(proxied, args);
        System.out.println("proxy method after");
        return null;
    }
}
