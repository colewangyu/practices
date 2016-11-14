
import java.util.ArrayList;

/**
 * Created by wy on 2016-09-04.
 */
public class PostOrderTraversal {
    private ArrayList<Integer> arr = new ArrayList<Integer>();

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return arr;
        if (root.left != null) postorderTraversal(root.left);
        if (root.right != null) postorderTraversal(root.right);
        arr.add(root.val);
        return arr;
    }

    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
