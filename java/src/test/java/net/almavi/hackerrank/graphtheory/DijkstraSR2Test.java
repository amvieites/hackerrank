package net.almavi.hackerrank.graphtheory;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 08/08/2015.
 */
public class DijkstraSR2Test {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out;

    @Before
    public void setUp() throws Exception {
        out = new ByteArrayOutputStream();
    }

    @Test
    public void testDijkstra() throws Exception {
        DijkstraSR2.Graph graph = new DijkstraSR2.Graph(4);
        graph.add(0, 0, 0);
        graph.add(0, 1, 24);
        graph.add(0, 3, 20);
        graph.add(2, 0, 3);
        graph.add(3, 2, 12);

        int[] result = DijkstraSR2.dijkstra(graph, 0);
        assertArrayEquals(new int[]{0, 24, 3, 15}, result);
    }

    @Test
    public void testChallengeHR0() throws Exception {
        String inputString = "1\n4 4\n1 2 24\n1 4 20\n3 1 3\n4 3 12\n1";
        String expected = "24 3 15";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        DijkstraSR2.challenge(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    @Test
    public void testChallengeHR0Bis() throws Exception {
        String inputString = "2\n4 4\n1 2 24\n1 4 20\n3 1 3\n4 3 12\n1\n3 3\n1 2 1\n1 3 1\n2 3 3\n2";
        String expected = "24 3 15" + System.lineSeparator() + "1 2";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        DijkstraSR2.challenge(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }


    @Test
    public void testHR3() throws Exception {
        FileInputStream filein = new FileInputStream(getClass().getClassLoader().getResource("graphtheory/dijkstra1.in").getFile());
        StringBuilder expected = new StringBuilder();
        BufferedReader fileout = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("graphtheory/dijkstra1.out").getFile()));
        while(fileout.ready()) {
            expected.append(fileout.readLine()).append(System.lineSeparator());
        }

        DijkstraSR2.challenge(filein, new PrintStream(this.out));

        assertEquals(expected.toString(), this.out.toString());
    }

}