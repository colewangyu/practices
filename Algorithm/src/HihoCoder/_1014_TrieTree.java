package HihoCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1014_TrieTree {
    private TrieTreeNode root;

    public _1014_TrieTree() {
        this.root = new TrieTreeNode();
    }

    public static void main(String[] args) {
        _1014_TrieTree t = new _1014_TrieTree();

        Scanner input = new Scanner(System.in);
        int length = new Integer(input.nextLine());
        for (int i = 0; i < length; i++) {
            t.insertTrieTreeNode(input.nextLine());
        }

        length = new Integer(input.nextLine());
        for (int i = 0; i < length; i++) {
            System.out.println(t.countPrefix(input.nextLine()));
        }
    }

    public boolean insertTrieTreeNode(String word) {
        // validate input argument
        if (word.length() < 1) {
            return false;
        }
        char[] chrs = word.toCharArray();
        TrieTreeNode curParentNode = root;
        // insert node
        for (int i = 0; i < chrs.length; i++) {
            if (!curParentNode.sons.containsKey(chrs[i])) {
                curParentNode.sons.put(chrs[i], new TrieTreeNode());
            }
            curParentNode = curParentNode.sons.get(chrs[i]);
            curParentNode.num++;
        }
        return true;
    }

    public int countPrefix(String word) {
        // validate prefix
        if (word.length() == 0 || word.trim().length() == 0) {
            return -1;
        } else {
            char[] chrs = word.toCharArray();
            TrieTreeNode curParentNode = root;
            int i;
            for (i = 0; i < chrs.length; i++) {
                if (curParentNode.sons.containsKey(chrs[i])) {
                    curParentNode = curParentNode.sons.get(chrs[i]);
                } else {
                    break;
                }
            }
            if (i == chrs.length) {
                return curParentNode.num;
            } else {
                return 0;
            }
        }
    }

    private class TrieTreeNode {
        private Map<Character, TrieTreeNode> sons;
        private int num;

        public TrieTreeNode() {
            this.num = 0;
            this.sons = new HashMap<Character, TrieTreeNode>();
        }
    }
}
