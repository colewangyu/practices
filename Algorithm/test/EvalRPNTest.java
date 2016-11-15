import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wy on 2016-09-04.
 */
public class EvalRPNTest {

    @Test
    public void testEvalRPN() throws Exception {
        assertEquals(-1, EvalRPN.evalRPN(new String[]{"3","-4","+"}));
        assertEquals(0, EvalRPN.evalRPN(new String[]{"0","3","/"}));
    }
}