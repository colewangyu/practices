package HuaWei;

import java.util.Scanner;

/**
 * Created by cole on 2016-08-16.
 * <p/>
 * 计算还息超过还本的月数
 */
public class InterPrincMonth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            //获取输入
            String line = in.nextLine();
            String[] strs = line.split(" ");
            //转换输入值
            //贷款本金
            double principal = new Double(strs[0]) * 10000;
            //还款月数
            int months = new Integer(strs[1]) * 12;
            //月利息
            double rateMonth = new Double(strs[2]) / 1200;

            //计算每个月还款 X=Aβ(1+β)^m/[(1+β)^m-1]
            double perMon = principal * rateMonth * Math.pow((1 + rateMonth), months) / (Math.pow((1 + rateMonth), months) - 1);

            // 月还利息
            double interestMonth = 0.0;
            // 月还本金
            double principalMonth = 0.0;
            // 月数
            int count = 0;
            do {
                //累加月数
                count++;
                //计算月还利息金额: = 贷款本金 * 月还利息
                interestMonth = principal * rateMonth;
                //计算月还本金金额: = 月还金额 - 月还利息
                principalMonth = perMon - interestMonth;
                //重新计算本金: = 贷款本金 - 月还本金
                principal -= principalMonth;
            }
            //月还利息 - 月还本金 >= 0 并且 贷款本金 > 0
            while (Double.compare(interestMonth, principalMonth) >= 0 && Double.compare(principal, 0) > 0);
            //月还利息 - 月还本金 >= 0, 没有出现还本多于还息的情况.
            if (Double.compare(interestMonth, principalMonth) >= 0)
                count = 0;
            System.out.println(strs[0] + " " + strs[1] + " " + strs[2] + " " + count);
        }
    }
}
