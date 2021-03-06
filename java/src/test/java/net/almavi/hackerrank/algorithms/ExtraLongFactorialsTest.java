package net.almavi.hackerrank.algorithms;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

/**
 * Created by Alex on 07/08/2015.
 */
public class ExtraLongFactorialsTest extends TestCase {

    public void testFactorial1() throws Exception {
        String inputString = "1";
        String expected = "1";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ExtraLongFactorials.factorial(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    public void testFactorial() throws Exception {
        String inputString = "6";
        String expected = "720";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ExtraLongFactorials.factorial(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    public void testFactorialAverage() throws Exception {
        String inputString = "15";
        String expected = "1307674368000";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ExtraLongFactorials.factorial(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    public void testFactorialBig() throws Exception {
        String inputString = "20";
        String expected = "2432902008176640000";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ExtraLongFactorials.factorial(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }

    public void testFactorial100() throws Exception {
        String inputString = "100";
        String expected = new BigDecimal("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000").toPlainString();
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ExtraLongFactorials.factorial(in, new PrintStream(out));
        assertEquals(expected, out.toString());
    }
}