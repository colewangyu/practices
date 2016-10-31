package NetEase;

import java.util.ArrayList;

/**
 * Created by wy on 2016-08-09.
 */
public class GetAllAdd {

    /**
     * 获取到所有的加数组合
     * 比如：输入2，输出1+1=2，2=2
     *
     * @param number 总数
     * @return 所有加数的组合
     */
    public ArrayList<String> getAllAdd(int number) {
        ArrayList<String> result = new ArrayList<String>();
        recursionGetAllAdd(0, number, "="+number, result);
        for(String s : result)
            System.out.println(s);
        return result;
    }

    public void recursionGetAllAdd(int number, int remainder, String s, ArrayList<String> result) {
        if (remainder == 0) {
            result.add(s);
//            System.out.println(s);
        }
        String str;
        for (int i = 1; i <= remainder; i++) {
            if(number != 0 && i > number) break;
            if(s.indexOf('=') == 0)
                str = i + s;
            else
                str = i + "+" + s;
            recursionGetAllAdd(i, remainder - i, str, result);
        }
    }
}
