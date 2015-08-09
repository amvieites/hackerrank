package net.almavi.hackerrank.graphtheory;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 09/08/2015.
 */
public class RustAndMurdererTest {
    private ByteArrayInputStream in;
    private ByteArrayOutputStream out;

    @Before
    public void setUp() throws Exception {
        out = new ByteArrayOutputStream();
    }

    @Test
    public void testChallengeHR0() throws Exception {
        String inputString = "1\n4 2\n1 2\n1 3\n1";
        String expected = "2 2 1" + System.lineSeparator();
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());

        RustAndMurderer.challenge(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    @Test
    public void testHR1() throws Exception {
        FileInputStream filein = new FileInputStream(getClass().getClassLoader().getResource("graphtheory/rustandmurderer1bis.in").getFile());
        StringBuilder expected = new StringBuilder();
        BufferedReader fileout = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("graphtheory/rustandmurderer1bis.out").getFile()));
        while(fileout.ready()) {
            expected.append(fileout.readLine()).append(System.lineSeparator());
        }

        RustAndMurderer.challenge(filein, new PrintStream(this.out));

        assertEquals(expected.toString(), this.out.toString());
    }
}