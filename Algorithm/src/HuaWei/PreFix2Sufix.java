package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wy on 2016-09-06.
 * 前缀转后缀，将前缀转换为树，然后再采用后序遍历树。
 * 输入样例：-,+,a,*,+,b,c,d,e
 * 输出样例：a,b,c,+,d,*,+,e,-
 */
public class PreFix2Sufix {
    static final String oper = "+-*/";
    public static void preFix2Sufix(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(",");
        if(strs.length < 3) {
            for(int i = strs.length - 1; i > 0; i--) {
                System.out.print(strs[i] + ",");
            }
            System.out.println(strs[0]);
            return;
        }
        Node root = new Node(null, null, null);
        createTree(root, strs, 0);
        ArrayList<String> arr = new ArrayList<String>();
        print(root, arr);
        for(int i = 0; i < arr.size() - 1; i++) {
            System.out.print(arr.get(i) + ",");
        }
        System.out.println(arr.get(arr.size()-1));
    }

    private static void print(Node root, ArrayList<String> arr) {
        if(root.left != null)
            print(root.left, arr);
        if(root.right != null)
            print(root.right, arr);
        arr.add(root.value);
    }

    private static int createTree(Node root, String[] strs, int index) {
        if(index >= strs.length) return index;
        if(oper.contains(strs[index])){
            root.value = strs[index];
            // 遍历生成左子树
            root.left = new Node(null);
            index = createTree(root.left, strs, index+1);
            // 遍历生成右子树
            root.right = new Node(null);
            return createTree(root.right, strs, index);
        } else {
            root.value = strs[index];
            return index + 1;
        }
    }

    private static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
