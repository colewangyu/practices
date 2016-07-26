package Ali;

/**
 * Created by wy on 2016-07-18.
 */
public class AliInterview {
    /**
     * 递归逆序int类型，返回字符串
     * @param i 输入的整形数值
     * @return 逆序的字符串
     */
    public String recursionReverse(int i) {
        //输入有效性判断
        if(i < 0) throw new IllegalArgumentException("输入不可为负数："+ i);
        //递归退出条件
        if (i < 10) return String.valueOf(i);
        //执行递归
        return recursionReverse(i % 10) + recursionReverse(i / 10);
    }
}
