package Level_1;

import java.util.Scanner;

/**
 * Created by home on 2015-10-16.
 */
public class _1039_RemoveChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte lineNumber = scanner.nextByte();
        StringBuffer line;  //暂存一行数据ß
        StringBuffer temp;  //临时存放插入字母后的数据
        int score;  //得分
        int maxScore = 0; //最高得分

        while (scanner.hasNext()) {
            //获取一行数据
            line = new StringBuffer(scanner.next());
            //重置最高得分
            maxScore = 0;

            //遍历所有可能的插入情况
            for (int i = 0; i < line.length(); i++) {
                for (char ch = 'A'; ch <= 'C'; ch++) {
                    temp = new StringBuffer(line);
                    temp.insert(i, ch);
                    score = computeMaxScore(temp);
                    if (score > maxScore) {
                        maxScore = score;
                    }
                }
            }
            System.out.println(maxScore);
        }
    }

    public static int computeMaxScore(StringBuffer line) {
        int lineLength = line.length();  //字符串的长度，得分上限
        int finalScore = 0;  //最终得分
        int currentScore = 0;   //本次消减后的得分

        do {
            finalScore = currentScore;
            //获取消减一次的字符串
            line = remove(line);
            //计算本次得分
            currentScore = lineLength - line.length();
        } while (currentScore > finalScore);
        return finalScore;
    }

    public static StringBuffer remove(StringBuffer line) {
        StringBuffer tmp = new StringBuffer();
        int i,j;
        for (i = 0; i < line.length(); i++) {
           for (j = i + 1; j < line.length(); j++ ) {
               if (line.charAt(i) != line.charAt(j)) {
                   tmp.append(line.charAt(i));
               }
               else {
                    while(j < line.length() && line.charAt(i) == line.charAt(j))
                        j++;
               }
               i = j;
           }
            if (j == line.length())
                tmp.append(line.charAt(i));
        }

        return tmp;
    }
}
