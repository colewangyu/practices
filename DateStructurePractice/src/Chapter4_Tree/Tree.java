package Chapter4_Tree;

import java.util.TreeSet;

/**
 * Created by cole on 4/17/16.
 */
public class Tree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode t7 = tree.new TreeNode(7, null, null);
        TreeNode t6 = tree.new TreeNode(6, null, null);
        TreeNode t5 = tree.new TreeNode(5, null, t6);
        TreeNode t4 = tree.new TreeNode(4, null, null);
        TreeNode t3 = tree.new TreeNode(3, t7, t4);
        TreeNode t2 = tree.new TreeNode(2, t5, t3);
        TreeNode t1 = tree.new TreeNode(1, t2, null);

        traverseDLR(t1);
        System.out.println();
        traverseLRD(t1);
    }

    /**
     * 先序遍历(先根遍历)
     *
     * @param rootNode
     */
    public static void traverseDLR(TreeNode rootNode) {
        //判断节点是否为空
        if (rootNode == null || rootNode.getElement() == null) {
            //如果为空，则跳出本方法
            return;
        } else {
            //如果不为空，输出当前节点，递归遍历其长，然后依次遍历其他儿子
            rootNode.printElement();
            //判断长子是否为空，不为空则递归遍历长子
            TreeNode firstNode = rootNode.getFirstChild();
            if (firstNode != null && firstNode.getElement() != null) {
                traverseDLR(firstNode);
                //遍历完长子，遍历其它儿子
                TreeNode nextSiblingNode = firstNode.getNextSibling();
                while (nextSiblingNode != null && nextSiblingNode.getElement() != null) {
                    traverseDLR(nextSiblingNode);
                    nextSiblingNode = nextSiblingNode.getNextSibling();
                }
            } else {
                //如果长子为空，则跳出
                return;
            }
        }
    }

    /**
     * 后序遍历（后根遍历）
     *
     * @param rootNode
     */
    public static void traverseLRD(TreeNode rootNode) {
        //判断节点是否为空
        if (rootNode == null || rootNode.getElement() == null) {
            //如果为空，则跳出本方法
            return;
        } else {
            //如果不为空，递归遍历其长子，然后依次遍历其他儿，最后输出当前节点
            TreeNode firstNode = rootNode.getFirstChild();
            //判断长子是否为空，不为空则递归遍历长子
            if (firstNode != null && firstNode.getElement() != null) {
                traverseLRD(firstNode);
                //遍历完长子，然后遍历其它儿子
                TreeNode nextSiblingNode = firstNode.getNextSibling();
                while (nextSiblingNode != null && nextSiblingNode.getElement() != null) {
                    traverseLRD(nextSiblingNode);
                    nextSiblingNode = nextSiblingNode.getNextSibling();
                }
            } else {
                ;
            }
            //遍历完所有子节点，输出当前节点
            rootNode.printElement();
        }
    }

    private class TreeNode {
        private Object element;  //树节点保持的数据
        private TreeNode firstChild; //长子节点
        private TreeNode nextSibling; //下一个兄弟节点

        public TreeNode(Object element, TreeNode firstChild, TreeNode nextSibling) {
            this.element = element;
            this.firstChild = firstChild;
            this.nextSibling = nextSibling;
        }

        public void printElement() {
            System.out.print(element);
        }

        public Object getElement() {
            return element;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        public TreeNode getFirstChild() {
            return firstChild;
        }

        public void setFirstChild(TreeNode firstChild) {
            this.firstChild = firstChild;
        }

        public TreeNode getNextSibling() {
            return nextSibling;
        }

        public void setNextSibling(TreeNode nextSibling) {
            this.nextSibling = nextSibling;
        }
    }
}


