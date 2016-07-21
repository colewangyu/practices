package Chapter4_Tree;

/**
 * Created by cole on 2016-05-12 Thursday.
 * <p/>
 * 实现泛型E,E必须实现了Comparable接口,并且实现的接口规定的泛型可以是E或E的父类
 */
public class AVLTree<E extends Comparable<? super E>> {

    private static final int ALLOWED_IMBALANCE = 2;
    /**
     * 根节点
     */
    private AvlNode root;

    /**
     * 插入一个点到Avl树中，重复的值会被忽略
     *
     * @param e 需要插入树中的值
     * @return 子树的新的根节点
     */
    public AvlNode insert(E e) {
        root = this.insert(e, root);
        return root;
    }

    /**
     * 内部方法,用于将新值建立一个新的节点,并插入到子树中.
     *
     * @param e 需要插入树中的值
     * @param n 被插入的子树的根节点
     * @return 子树的新的根节点
     */
    private AvlNode insert(E e, AvlNode<E> n) {
        //判断输入有效性
        if (e == null) {
            throw new NullPointerException();
        }
        //找到插入位置，新增一个节点并返回
        if (n == null) {
            return new AvlNode(e, null, null);
        }

        //比较大小,-1:插入值小,0:相等,1:插入值大
        int compareResult = compare(e, n.e);

        // 插入值小，将其插入其左儿子为根节点的子树中
        // 插入值大，将其插入其右儿子为根节点的子树中
        if (compareResult < 0) {
            //执行插入
            n.left = insert(e, n.left);
        } else if (compareResult > 0) {
            n.right = insert(e, n.right);
        } else {
            //值重复，不执行操作
        }
        //保持平衡
        n = balance(n);
        //更新高度
        n.height = Math.max(getNodeHeight(n.left), getNodeHeight(n.right)) + 1;
        return n;
    }

    /**
     * 调节传入节点左右子树的平衡，如果调节节点，则会进行节点高度的重置，否则不对节点高度进行修改
     *
     * @param n 进行平衡的子树的根节点
     * @return 新的根节点，如果传入null则返回null
     */
    private AvlNode balance(AvlNode n) {
        //判断输入数据有效性，如果为null返回null
        if (n == null) {
            return n;
        }
        //比较左右儿子的高度，如果超过限制高度差（默认为2），则需要进行平衡
        //如果左儿子高度大，对左子树进行判断后执行平衡
        if (getNodeHeight(n.left) - getNodeHeight(n.right) >= ALLOWED_IMBALANCE) {
            //判断左儿子的左右儿子的高度，如果左儿子高度大于等于右儿子，则进行单旋转，否则进行双旋转
            if (getNodeHeight(n.left.left) >= getNodeHeight(n.left.right)) {
                n = rotateRight(n);
            } else {
                n = doubleRotateRight(n);
            }
        }
        //如果右儿子高度大，对右子树进行判断后执行平衡
        else if (getNodeHeight(n.right) - getNodeHeight(n.left) >= ALLOWED_IMBALANCE) {
            if (getNodeHeight(n.right.right) >= getNodeHeight(n.right.left)) {
                n = rotateLeft(n);
            } else {
                n = doubleRotateLeft(n);
            }
        }
        //

        return n;
    }

    /**
     * 节点向左旋转
     *
     * @param n 需要旋转的节点（为该旋转子树的根）
     * @return 该子树旋转后的新的根节点
     */
    private AvlNode rotateLeft(AvlNode<E> n) {
        AvlNode n2 = n.right;
        //根节点右儿子替换为其右儿子的左儿子
        n.right = n.left;
        //根节点的右儿子的左儿子替换为根节点
        n2.left = n;
        //更新两个节点的高度
        n.height = Math.max(getNodeHeight(n.left), getNodeHeight(n.right)) + 1;
        n2.height = Math.max(getNodeHeight(n2.left), getNodeHeight(n2.right)) + 1;
        //返回旋转后该子树新的根节点
        return n2;
    }

    /**
     * 节点向左双旋转
     *
     * @param n 需要旋转的节点（为该旋转子树的根）
     * @return 该子树旋转后的新的根节点
     */
    private AvlNode doubleRotateLeft(AvlNode n) {
        //对根节点右儿子进行向右的单旋转
        n.right = rotateRight(n.right);
        //对根节点进行向左单旋转
        return rotateLeft(n);
    }

    /**
     * 节点向右旋转
     *
     * @param n 需要旋转的节点（为该旋转子树的根）
     * @return 该子树旋转后的新的根节点
     */
    private AvlNode rotateRight(AvlNode<E> n) {
        AvlNode n2 = n.left;
        //根节点左儿子替换为其左儿子的右儿子
        n.left = n2.right;
        //根节点的左儿子的右儿子替换为根节点
        n2.right = n;
        //更新两个节点的高度
        n.height = Math.max(getNodeHeight(n.left), getNodeHeight(n.right)) + 1;
        n2.height = Math.max(getNodeHeight(n2.left), getNodeHeight(n2.right)) + 1;
        //返回旋转后该子树新的根节点
        return n2;
    }

    /**
     * 节点向右双旋转
     *
     * @param n 需要旋转的节点（为该旋转子树的根）
     * @return 该子树旋转后的新的根节点
     */
    private AvlNode doubleRotateRight(AvlNode n) {
        //对根节点左儿子进行向左的单旋转
        n.left = rotateLeft(n.left);
        //对根节点进行向右单旋转
        return rotateRight(n);
    }

    private int compare(E a, E b) {
        return a.compareTo(b);
    }

    /**
     * 返回节点高度,如果为null返回-1，叶子节点高度为0
     *
     * @param n 需要返回高度的节点
     * @return 节点的高度
     */
    private int getNodeHeight(AvlNode n) {
        return n == null ? -1 : n.height;
    }

    static class AvlNode<E> {
        E e; //节点的数据
        AvlNode<E> left; //左儿子节点
        AvlNode<E> right; //右儿子节点
        int height;  //节点的深度

        public AvlNode(E e) {
            this(e, null, null);
        }

        public AvlNode(E e, AvlNode<E> left, AvlNode<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
            //默认高度为0
            height = 0;
        }
    }
}
