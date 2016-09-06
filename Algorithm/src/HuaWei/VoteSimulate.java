package HuaWei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wy on 2016-09-06.
 * 样例输入：
 *      addCandidate c1
 *      addCandidate c2
 *      addCandidate c3
 *      addCandidate c4
 *      vote c1
 *      vote c2
 *      vote c3
 *      vote c4
 *      vote c5
 *      getVoteResult
 * 样例输出：
 *      c1 1
 *      c2 1
 *      c3 1
 *      c4 1
 *      1
 */
public class VoteSimulate {
    public static void voteSimulate(String[] args) {
        Scanner in = new Scanner(System.in);

        String getResult = "getVoteResult";
        String addCandidate = "addCandidate";
        String vote = "vote";
        Map<String, Integer> voteResult = new HashMap<String, Integer>();
        ArrayList<String> voteSort = new ArrayList<String>();
        String cmd;
        String arg = null;
        String[] tmp;
        int countInvalid = 0;
        while(true) {
            tmp = in.nextLine().split(" ");
            if(tmp.length == 1) {
                cmd = tmp[0];
            } else if(tmp.length == 2) {
                cmd = tmp[0];
                arg = tmp[1];
            } else {
                continue;
            }
            if(cmd.equals(getResult)) {
                // 输出
                for(String s : voteSort) {
                    System.out.println(s + " " + voteResult.get(s));
                }
                System.out.println(countInvalid);
                break;
            }
            else if(cmd.equals(addCandidate)) {
                if(voteResult.containsKey(arg))
                    continue;
                voteResult.put(arg, 0);
                voteSort.add(arg);
            } else if(cmd.equals(vote)) {
                if (voteResult.containsKey(arg)){
                    voteResult.put(arg, voteResult.get(arg) + 1);
                } else {
                    countInvalid++;
                }
            }
        }
    }
}
