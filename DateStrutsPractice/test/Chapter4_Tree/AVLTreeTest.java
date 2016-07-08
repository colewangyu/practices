package Chapter4_Tree;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-05-15.
 */
public class AVLTreeTest {
    static AVLTree.AvlNode root;
    static AVLTree.AvlNode n1;
    static AVLTree.AvlNode n2;
    static AVLTree.AvlNode n3;
    static AVLTree.AvlNode n4;
    static AVLTree.AvlNode n5;


   /* @BeforeClass
    public static void setUp() {
        n5 = new AVLTree.AvlNode<Integer>(5);
        n4 = new AVLTree.AvlNode<Integer>(4);
        n3 = new AVLTree.AvlNode<Integer>(3);
        n2 = new AVLTree.AvlNode<Integer>(2);
        n1 = new AVLTree.AvlNode<Integer>(1);
    }*/

    @Test
    public void testInsert() throws Exception {
        AVLTree t = new AVLTree<Integer>();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        root = t.insert(5);

        assertEquals(root.height, 2);
        assertEquals(root.left.height, 0);
        assertEquals(root.right.height, 1);
    }
}