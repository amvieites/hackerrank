package net.almavi.hackerrank.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 08/08/2015.
 */
public class ClosestNumbersTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out;

    @Before
    public void setUp() throws Exception {
        out = new ByteArrayOutputStream();
    }

    @Test
    public void testBase() throws Exception {
        String inputString = "2\n2 1";
        String expected = "1 2";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        ClosestNumbers.sort(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    @Test
    public void testHR0() throws Exception {
        String inputString = "10\n-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854";
        String expected = "-20 30";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        ClosestNumbers.sort(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    @Test
    public void testHR1() throws Exception {
        String inputString = "12\n-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470";
        String expected = "-520 -470 -20 30";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        ClosestNumbers.sort(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    @Test
    public void testHR2() throws Exception {
        String inputString = "4\n5 4 3 2";
        String expected = "2 3 3 4 4 5";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        ClosestNumbers.sort(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    @Test
    public void testHR3() throws Exception {
        FileInputStream filein = new FileInputStream(getClass().getClassLoader().getResource("algorithms/closestnumbers1.in").getFile());
        String expected = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("algorithms/closestnumbers1.out").getFile())).readLine();

        ClosestNumbers.sort(filein, new PrintStream(out));

        assertEquals(expected, out.toString());
    }

    @Test
    public void testInsert() throws Exception {
        int[] array = new int[10000];
        for (int i = 0; i < 10000; i++) {
            ClosestNumbers.insertSorted(array, 10000 - 1, new Random().nextInt());
        }

        for (int i = 1; i < array.length; i++) {
            assert(array[i-1] <= array[i]);
        }
    }
}