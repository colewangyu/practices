package MyTest.JavaGrammar;

/**
 * Created by wy on 2016-08-18.
 *
 * 【验证目的】方法重载的测试
 * 【验证结果】
 *  1. 返回值不需要一样。
 *  2. 方法参数个数或类型需要不一样。
 */
public class OverloadTest {
    public void a(){
        System.out.println(Thread.currentThread().getStackTrace()[1]);
    }

    public int a(int i){
        System.out.println(i);
        System.out.println(Thread.currentThread().getStackTrace()[1]);
        return 1;
    }

    public static void main(String[] args) {
        OverloadTest t = new OverloadTest();
        t.a();
        t.a(1);
    }
}
