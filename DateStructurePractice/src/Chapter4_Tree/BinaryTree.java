package Chapter4_Tree;

import java.io.BufferedReader;

/**
 * Created by wy on 2016-04-19.
 */
public class BinaryTree {
    StringBuffer s = new StringBuffer();

    /**
     * 先序遍历
     *
     * @param rootNode
     */
    public void DLR(BinaryNode rootNode) {

        if (rootNode != null && rootNode.getElement() != null) {

            //输出当前节点
            s.append(rootNode.getElement());

            //遍历左子树
            DLR(rootNode.leftNode);

            //遍历右子树
            DLR(rootNode.rightNode);

        } else {
            //do nothing
        }
    }

    /**
     * 中序遍历
     *
     * @param rootNode
     */
    public void LDR(BinaryNode rootNode) {
        if (rootNode != null && rootNode.getElement() != null) {

            //遍历左子树
            BinaryNode leftNode = rootNode.getLeftNode();
            LDR(leftNode);

            //输出当前节点
            s.append(rootNode.getElement());

            //遍历右子树
            BinaryNode rightNode = rootNode.getRightNode();
            LDR(rightNode);

        } else {
            //do nothing
        }
    }

    /**
     * 后序遍历
     *
     * @param rootNode
     */
    public void LRD(BinaryNode rootNode) {
        if (rootNode != null && rootNode.getElement() != null) {

            //遍历左子树
            BinaryNode leftNode = rootNode.getLeftNode();
            LRD(leftNode);

            //遍历右子树
            BinaryNode rightNode = rootNode.getRightNode();
            LRD(rightNode);

            //输出当前节点
            s.append(rootNode.getElement());

        } else {
            //do nothing
        }
    }

    static class BinaryNode {
        private Object element;
        private BinaryNode leftNode;
        private BinaryNode rightNode;

        public BinaryNode(Object element, BinaryNode leftNode, BinaryNode rightNode) {
            this.element = element;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
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

        public BinaryNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(BinaryNode leftNode) {
            this.leftNode = leftNode;
        }

        public BinaryNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(BinaryNode rightNode) {
            this.rightNode = rightNode;
        }
    }
}


