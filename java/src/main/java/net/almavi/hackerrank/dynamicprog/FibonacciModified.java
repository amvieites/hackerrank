package net.almavi.hackerrank.dynamicprog;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 *
 * Created by Alex on 08/08/2015.
 */
public class FibonacciModified {

    public static void main(String[] args) {
        calcFib(System.in, System.out);
    }

    public static void calcFib(InputStream in, PrintStream out) {
        Scanner input = new Scanner(in);
        int a = input.nextInt(),
            b = input.nextInt(),
            n = input.nextInt();

        out.print(fibMod(new BigInteger(String.valueOf(a)), new BigInteger(String.valueOf(b)), 3, n));
    }

    private static BigInteger fibMod(BigInteger a, BigInteger b, int i, int n) {
        if (i < n) {
            return fibMod(b, a.add(b.pow(2)), ++i, n);
        } else {
            return a.add(b.pow(2));
        }
    }
}
