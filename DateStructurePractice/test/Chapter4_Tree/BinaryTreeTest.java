package Chapter4_Tree;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by wy on 2016-05-12.
 */
public class BinaryTreeTest {
    static BinaryTree t;
    static BinaryTree.BinaryNode t7;
    static BinaryTree.BinaryNode t6;
    static BinaryTree.BinaryNode t5;
    static BinaryTree.BinaryNode t4;
    static BinaryTree.BinaryNode t3;
    static BinaryTree.BinaryNode t2;
    static BinaryTree.BinaryNode t1;

    static BinaryTree.BinaryNode t11;
    static BinaryTree.BinaryNode t12;
    static BinaryTree.BinaryNode t13;
    static BinaryTree.BinaryNode t14;

    static BinaryTree.BinaryNode t21;
    static BinaryTree.BinaryNode t22;
    static BinaryTree.BinaryNode t23;
    static BinaryTree.BinaryNode t24;

    static BinaryTree.BinaryNode t31;
    static BinaryTree.BinaryNode t32;
    static BinaryTree.BinaryNode t33;
    static BinaryTree.BinaryNode t34;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        t = new BinaryTree();
        t7 = new BinaryTree.BinaryNode(7, null, null);
        t6 = new BinaryTree.BinaryNode(6, null, null);
        t5 = new BinaryTree.BinaryNode(5, null, null);
        t4 = new BinaryTree.BinaryNode(4, null, null);
        t3 = new BinaryTree.BinaryNode(3, t6, t7);
        t2 = new BinaryTree.BinaryNode(2, t4, t5);
        t1 = new BinaryTree.BinaryNode(1, t2, t3);
        t14 = new BinaryTree.BinaryNode(4, null, null);
        t13 = new BinaryTree.BinaryNode(3, t14, null);
        t12 = new BinaryTree.BinaryNode(2, t13, null);
        t11 = new BinaryTree.BinaryNode(1, t12, null);
        t24 = new BinaryTree.BinaryNode(4, null, null);
        t23 = new BinaryTree.BinaryNode(3, null, t24);
        t22 = new BinaryTree.BinaryNode(2, null, t23);
        t21 = new BinaryTree.BinaryNode(1, null, t22);
        t34 = new BinaryTree.BinaryNode(4, null, null);
        t33 = new BinaryTree.BinaryNode(3, t34, null);
        t32 = new BinaryTree.BinaryNode(2, null, t33);
        t31 = new BinaryTree.BinaryNode(1, t32, null);
    }

    @Test
    public void testDLR() throws Exception {
        t.s.delete(0, t.s.length());
        t.DLR(t1);
        assertEquals("1245367", t.s.toString());
        t.s.delete(0, t.s.length());
        t.DLR(t11);
        assertEquals("1234", t.s.toString());
        t.s.delete(0, t.s.length());
        t.DLR(t21);
        assertEquals("1234", t.s.toString());
        t.s.delete(0, t.s.length());
        t.DLR(t31);
        assertEquals("1234", t.s.toString());
    }

    @Test
    public void testLDR() throws Exception {
        t.s.delete(0, t.s.length());
        t.LDR(t1);
        assertEquals("4251637", t.s.toString());
        t.s.delete(0, t.s.length());
        t.LDR(t11);
        assertEquals("4321", t.s.toString());
        t.s.delete(0, t.s.length());
        t.LDR(t21);
        assertEquals("1234", t.s.toString());
        t.s.delete(0, t.s.length());
        t.LDR(t31);
        assertEquals("2431", t.s.toString());
    }

    @Test
    public void testLRD() throws Exception {
        t.s.delete(0, t.s.length());
        t.LRD(t1);
        assertEquals("4526731", t.s.toString());
        t.s.delete(0, t.s.length());
        t.LRD(t11);
        assertEquals("4321", t.s.toString());
        t.s.delete(0, t.s.length());
        t.LRD(t21);
        assertEquals("4321", t.s.toString());
        t.s.delete(0, t.s.length());
        t.LRD(t31);
        assertEquals("4321", t.s.toString());
    }
}