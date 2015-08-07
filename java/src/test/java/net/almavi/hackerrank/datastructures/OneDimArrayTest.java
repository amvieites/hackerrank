package net.almavi.hackerrank.datastructures;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Alex on 07/08/2015.
 */
public class OneDimArrayTest extends TestCase {

    public void testGameBaseCase() throws Exception {
        String inputString = "1\n2 2\n0 1";
        String expected = Result.YES.toString() + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        OneDimArray.game(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    public void testGameBase() throws Exception {
        String inputString = "1\n6 5\n0 0 0 0 0 0";
        String expected = Result.YES.toString() + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        OneDimArray.game(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    public void testGameN6M5() throws Exception {
        String inputString = "1\n6 5\n0 0 0 1 1 1";
        String expected = Result.YES.toString() + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        OneDimArray.game(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    public void testGameProvided() throws Exception {
        String inputString = "4\n5 3\n0 0 0 0 0\n6 5\n0 0 0 1 1 1\n6 3\n0 0 1 1 1 0\n3 1\n0 1 0";
        String expected = Result.YES.toString() + System.lineSeparator()
                + Result.YES.toString() + System.lineSeparator()
                + Result.NO.toString() + System.lineSeparator()
                + Result.NO.toString() + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        OneDimArray.game(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }
}