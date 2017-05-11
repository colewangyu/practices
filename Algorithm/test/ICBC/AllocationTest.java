package ICBC;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllocationTest {
    Allocation test;

    @Before
    public void setUp() throws Exception {
        test = new Allocation();
    }

    @After
    public void tearDown() throws Exception {
        test = null;
    }

    @Test
    public void testAllocation() throws Exception {
        List<String> ID = new ArrayList<String>();
        Map<String, Integer> weight = new HashMap<String, Integer>();
        ID.add("2016001");
        ID.add("2016002");
        ID.add("2016003");
        ID.add("2016004");
        ID.add("2016005");
        weight.put("J1", 1);
        weight.put("J2", 2);
        weight.put("J3", 1);
        Map<String, List<String>> result = test.allocation(ID, weight);
        System.out.println();
    }
}