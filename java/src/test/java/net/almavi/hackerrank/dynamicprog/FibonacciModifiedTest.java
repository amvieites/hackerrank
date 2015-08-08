package net.almavi.hackerrank.dynamicprog;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 08/08/2015.
 */
public class FibonacciModifiedTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out;

    @Before
    public void setUp() throws Exception {
        out = new ByteArrayOutputStream();
    }

    @Test
    public void testCalcFib6th() throws Exception {
        String inputString = "0 1 6";
        String expected = "27";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        FibonacciModified.calcFib(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    @Test
    public void testCalcFibHR0() throws Exception {
        String inputString = "0 1 5";
        String expected = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        FibonacciModified.calcFib(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }
}