package ZTE;

import java.util.HashMap;

/**
 * Created by cole on 2016-08-28.
 *
 */
public class WordList {
    public static void main(String[] args) {

    }

    /**
     * 判断单词数组能够收尾相接拼成一串,1:可以,0:不可以
     *
     * @param args
     * @return
     */
    public static int WordList(String[] args) {
        HashMap<Character, Integer> mapHead = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapTail = new HashMap<Character, Integer>();
        char head;
        char tail;
        boolean[] flag = new boolean[args.length];
        int count;
        int index;
        for(int i = 0; i < args.length; i++) {
            mapHead.put(args[i].charAt(0), i);
            mapTail.put(args[i].charAt(args[i].length() - 1), i);
            flag[i] = true;
        }
        for(int i = 0; i < args.length; i++) {
            tail = args[i].charAt(args[i].length() - 1);
            count = 0;
            while(true) {
                if((index = mapHead.get(tail)) >= 0) {
                    flag[index] = false;
                    mapHead.put(tail, -1);
                    count++;
                } else {
                    break;
                }
            }
            if(count == args.length)
                return 1;
            else
                return 0;
        }
        return -1;
    }
}
