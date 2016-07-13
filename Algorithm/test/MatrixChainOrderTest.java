import DynamicProgramming.MatrixChainOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-06-07.
 */
public class MatrixChainOrderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testMatrixChainOrder() throws Exception {
        MatrixChainOrder t = new MatrixChainOrder();
        assertEquals(60, t.matrixChainOrder(new int[]{10,3,2}));
        assertEquals(36, t.matrixChainOrder(new int[]{10,3,2,1}));
        assertEquals(15125, t.matrixChainOrder(new int[]{30,35,15,5,10,20,25}));
    }

    @Test
    public void testGetMatrixChainOrder() throws Exception {
        MatrixChainOrder t = new MatrixChainOrder();
        assertEquals("(A0A1)",t.getMatrixChainOrder(new int[]{10,3,2}));
        assertEquals("(A0(A1A2))",t.getMatrixChainOrder(new int[]{10,3,2,1}));
        assertEquals("((A0(A1A2))((A3A4)A5))",t.getMatrixChainOrder(new int[]{30,35,15,5,10,20,25}));
    }
}