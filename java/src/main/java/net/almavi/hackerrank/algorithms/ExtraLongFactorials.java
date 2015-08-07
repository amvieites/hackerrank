package net.almavi.hackerrank.algorithms;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

/**
 * Created by Alex on 07/08/2015.
 */
public class ExtraLongFactorials {

    private static final MathContext mathContext = MathContext.UNLIMITED;

    public static void main(String[] args) {
        factorial(System.in, System.out);
    }
    public static void factorial(InputStream in, PrintStream out) {
        Integer number = new Scanner(in).nextInt();
        out.print(loop(number, new BigDecimal(number)).toPlainString());
    }

    private static BigDecimal loop(Integer number, BigDecimal total) {
        return number.equals(1) ? total :
                loop(number - 1, new BigDecimal(number - 1).multiply(total, mathContext));
    }
}
