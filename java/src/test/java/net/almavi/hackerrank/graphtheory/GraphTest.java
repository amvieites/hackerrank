package net.almavi.hackerrank.graphtheory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 09/08/2015.
 */
public class GraphTest {

    @Test
    public void testRevert() throws Exception {
        RustAndMurderer.Graph graph = new RustAndMurderer.Graph(4);
        graph.add(0, 1, (byte)1);
        graph.add(2, 1, (byte)1);
        graph.add(1, 3, (byte)1);
        graph.add(1, 2, (byte)1);
        RustAndMurderer.Graph reverted = graph.revert();

        assertTrue(reverted.getDistance(0, 1) == -1);
        assertTrue(reverted.getDistance(2, 1) == -1);
        assertTrue(reverted.getDistance(1, 3) == -1);
        assertTrue(reverted.getDistance(1, 2) == -1);
        assertTrue(reverted.getDistance(0, 2) == 1);
        assertTrue(reverted.getDistance(0, 3) == 1);
        assertTrue(reverted.getDistance(2, 0) == 1);
        assertTrue(reverted.getDistance(2, 3) == 1);
        assertTrue(reverted.getDistance(3, 0) == 1);
        assertTrue(reverted.getDistance(3, 2) == 1);
    }
}