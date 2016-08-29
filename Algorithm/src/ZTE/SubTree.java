package ZTE;

/**
 * Created by wy on 2016-08-29.
 */
public class SubTree {

    public static int isSubTree(TNode root1, TNode root2) {
        if (root1.value == root2.value)
            if (isSTree(root1, root2))
                return 1;
        if (root1.left != null)
            if(isSubTree(root1.left, root2) == 1)
                return 1;
        if (root1.right != null)
            if(isSubTree(root1.right, root2) == 1)
                return 1;
        return -1;
    }

    public static boolean isSTree(TNode root1, TNode root2) {
        boolean flag = false;
        boolean flagL = false;
        boolean flagR = false;

        if (root1.value == root2.value) {
            // 判断左子树
            if (root1.left != null && root2.left != null) {
                flagL = isSTree(root1.left, root2.left);
            } else if (root1.left == null && root2.left == null) {
                flagL = true;
            }
            // 判断右子树
            if (root1.right != null && root2.right != null) {
                flagR = isSTree(root1.right, root2.right);
            } else if (root1.right == null && root2.right == null) {
                flagR = true;
            }
            // 综合左右子树
            if (flagL && flagR)
                flag = true;
        }
        return flag;
    }

    public static class TNode {
        int value;
        TNode left;
        TNode right;

        public TNode(int value, TNode left, TNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
