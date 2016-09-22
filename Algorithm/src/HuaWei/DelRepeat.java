package HuaWei;

import java.util.Scanner;

/**
 * Created by wy on 2016-09-09.
 * 删除重复字符
 */
public class DelRepeat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < line1.length(); i++) {
            if(!line2.contains(String.valueOf(line1.charAt(i))))
                sb.append(line1.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
