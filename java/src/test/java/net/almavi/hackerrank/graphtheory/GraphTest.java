package net.almavi.hackerrank.graphtheory;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Alex on 09/08/2015.
 */
public class GraphTest {

    @Test
    public void testNodeKey() throws Exception {
        RustAndMurderer.Graph graph = new RustAndMurderer.Graph(4);
        graph.add(0, 1);
        Set<Integer> expected = new HashSet<Integer>();
        expected.add(2);
        expected.add(3);
        assertEquals(expected, graph.getNonAdjacent(0));
    }
}