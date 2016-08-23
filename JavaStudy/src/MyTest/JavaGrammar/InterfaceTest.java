package MyTest.JavaGrammar;

/**
 * Created by wy on 2016-08-18.
 *
 * 验证接口方法和属性的默认修饰符
 */
public class InterfaceTest implements A {
    public static void main(String[] args) {
        System.out.println(A.a);
    }

    @Override
    public void a() {

    }
}

interface A{
    //不填即为public final static，只能为public final static（顺序可乱）
    public final static int a = 1;
    //不填即为public，只能为public
    public void a();
}