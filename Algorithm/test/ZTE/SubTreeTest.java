package ZTE;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-08-29.
 */
public class SubTreeTest {

    @Test
    public void testIsSubTree() throws Exception {
        SubTree.TNode t7 = new SubTree.TNode(7, null, null);
        SubTree.TNode t6 = new SubTree.TNode(6, null, null);
        SubTree.TNode t5 = new SubTree.TNode(5, null, null);
        SubTree.TNode t4 = new SubTree.TNode(4, null, null);
        SubTree.TNode t3 = new SubTree.TNode(3, t6, t7);
        SubTree.TNode t2 = new SubTree.TNode(2, t4, t5);
        SubTree.TNode t1 = new SubTree.TNode(1, t2, t3);

        assertEquals(1,SubTree.isSubTree(t1, t1));
        assertEquals(1,SubTree.isSubTree(t1, t2));
        assertEquals(1,SubTree.isSubTree(t1, t7));
        assertEquals(-1,SubTree.isSubTree(t7, t1));
        assertEquals(-1,SubTree.isSubTree(t2, t1));

        // 无效等价类
        SubTree.TNode tt13 = new SubTree.TNode(3, null, null);
        SubTree.TNode tt12 = new SubTree.TNode(2, null, null);
        SubTree.TNode tt1 = new SubTree.TNode(1, tt12, tt13);

        assertEquals(-1,SubTree.isSubTree(t1, tt1));

        SubTree.TNode tt25 = new SubTree.TNode(5, null, null);
        SubTree.TNode tt24 = new SubTree.TNode(4, null, null);
        SubTree.TNode tt23 = new SubTree.TNode(3, null, null);
        SubTree.TNode tt22 = new SubTree.TNode(2, tt24, tt25);
        SubTree.TNode tt2 = new SubTree.TNode(1, tt22, tt23);

        assertEquals(-1,SubTree.isSubTree(t1, tt2));

        // 左右
        SubTree.TNode tt33 = new SubTree.TNode(5, null, null);
        SubTree.TNode tt32 = new SubTree.TNode(2, null, tt33);
        SubTree.TNode tt3 = new SubTree.TNode(1, tt32, null);

        assertEquals(-1,SubTree.isSubTree(t1, tt3));

        // 右左
        SubTree.TNode tt43 = new SubTree.TNode(6, null, null);
        SubTree.TNode tt42 = new SubTree.TNode(3, tt43, null);
        SubTree.TNode tt4 = new SubTree.TNode(1, null, tt42);

        assertEquals(-1,SubTree.isSubTree(t1, tt4));

        // 超过
        SubTree.TNode tt53 = new SubTree.TNode(9, null, null);
        SubTree.TNode tt52 = new SubTree.TNode(8, null, null);
        SubTree.TNode tt5 = new SubTree.TNode(4, tt52, tt53);

        assertEquals(-1,SubTree.isSubTree(t1, tt5));

        // 未到底
        SubTree.TNode tt63 = new SubTree.TNode(3, null, null);
        SubTree.TNode tt62 = new SubTree.TNode(2, null, null);
        SubTree.TNode tt6 = new SubTree.TNode(1, tt62, tt63);

        assertEquals(-1,SubTree.isSubTree(t1, tt6));
    }
}