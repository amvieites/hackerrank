package net.almavi.hackerrank.datastructures;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Alex on 07/08/2015.
 */
public class OneDimArray {

    public static void main(String[] args) {
        game(System.in, System.out);
    }

    public static void game(InputStream in, PrintStream out) {
        Scanner input = new Scanner(in);
        Integer testCases = input.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] array = readArray(n, input);

            Result result = jumping(0, array, m);
            out.println(result != null ? result : Result.NO);
        }
    }

    private static Result jumping(int pos, int[][] array, int m) {
        if (pos < 0) {
            return Result.NO;
        } else if (pos >= array.length) {
            return Result.YES;
        } else if (array[pos][0] == 1) {
            array[pos][1] = 1;
            return Result.NO;
        } else if (isVisited(array, pos)) {
            array[pos][1] = 1;
            return Result.NO;
        } else {
            array[pos][1] = 1;
            return (Result.YES == jumping(pos - 1, array, m)
                    || Result.YES == jumping(pos + 1, array, m)
                    || Result.YES == jumping(pos + m, array, m)) ? Result.YES : Result.NO;
        }
    }

    private static boolean isVisited(int[][] array, int pos) {
        return array[pos][1] == 1;
    }

    private static int[][] readArray(int n, Scanner input) {
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = input.nextInt();
            array[i][1] = 0;
        }
        return array;
    }
}

enum Result {
    YES, NO
}