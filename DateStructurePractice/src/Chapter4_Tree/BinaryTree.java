package Chapter4_Tree;

import java.util.Stack;

/**
 * Created by wy on 2016-04-19.
 */
public class BinaryTree {
    StringBuffer s = new StringBuffer();

    /**
     * 先序遍历
     * 递归
     *
     * @param rootNode
     */
    public void DLR(BinaryNode rootNode) {

        if (rootNode != null && rootNode.getElement() != null) {
            //输出当前节点
            s.append(rootNode.getElement());
            //遍历左子树
            DLR(rootNode.getLeftNode());
            //遍历右子树
            DLR(rootNode.getRightNode());
        } else {
            //do nothing
        }
    }

    /**
     * 先序遍历
     * 非递归
     *
     * @param rootNode
     */
    public void DLRNonRecursion(BinaryNode rootNode) {

        if (rootNode != null && rootNode.getElement() != null) {
            Stack<BinaryNode> stack = new Stack<BinaryNode>();
            //输出当前节点
            s.append(rootNode.getElement());

            // 先将右儿子压栈
            if (rootNode.rightNode != null)
                stack.push(rootNode.rightNode);
            // 再将左儿子压栈
            if (rootNode.leftNode != null)
                stack.push(rootNode.leftNode);

            while (!stack.isEmpty()) {
                // 弹出一个儿子
                rootNode = stack.pop();
                if (rootNode != null) {
                    s.append(rootNode.getElement());
                    // 先将右儿子压栈
                    if (rootNode.rightNode != null)
                        stack.push(rootNode.rightNode);
                    // 再将左儿子压栈
                    if (rootNode.leftNode != null)
                        stack.push(rootNode.leftNode);
                }
            }
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
            LDR(rootNode.getLeftNode());
            //输出当前节点
            s.append(rootNode.getElement());
            //遍历右子树
            LDR(rootNode.getRightNode());

        } else {
            //do nothing
        }
    }

    /**
     * 中序遍历
     * 非递归
     *
     * @param rootNode
     */
    public void LDRNonRecursioin(BinaryNode rootNode) {
        if (rootNode != null && rootNode.getElement() != null) {
            Stack<BinaryNode> stack = new Stack();
            while (rootNode != null || !stack.isEmpty()) {
                // 循环压入左儿子节点
                while (rootNode != null) {
                    stack.push(rootNode);
                    rootNode = rootNode.getLeftNode();
                }
                // 处理右儿子节点
                if (!stack.isEmpty()) {
                    rootNode = stack.pop();
                    s.append(rootNode.getElement());
                    rootNode = rootNode.getRightNode();
                }
            }
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
            LRD(rootNode.getLeftNode());
            //遍历右子树
            LRD(rootNode.getRightNode());
            //输出当前节点
            s.append(rootNode.getElement());
        } else {
            //do nothing
        }
    }

    /**
     * 后序遍历
     * 非递归,单栈法
     *
     * @param rootNode
     */
    public void LRDNonRecursion(BinaryNode rootNode) {
        if (rootNode != null && rootNode.getElement() != null) {
            Stack<BinaryNode> stack = new Stack<BinaryNode>();
            BinaryNode prev = rootNode;
            while (rootNode != null || !stack.isEmpty()) {
                // 循环左儿子，依次入栈
                while (rootNode != null) {
                    stack.push(rootNode);
                    rootNode = rootNode.getLeftNode();
                }
                // 判断右儿子，如果为空或已输出过则输出当前节点
                BinaryNode tmp = stack.peek().getRightNode();
                if (tmp == null || tmp == prev) {
                    rootNode = stack.pop();
                    s.append(rootNode.getElement());
                    prev = rootNode;
                    // 输出过后要把该节点置空，否则会因为不断加入左儿子而陷入死循环
                    rootNode = null;
                } else {
                    rootNode = tmp;
                }
            }
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


