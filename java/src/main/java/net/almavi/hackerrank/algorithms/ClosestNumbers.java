package net.almavi.hackerrank.algorithms;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alex on 08/08/2015.
 */
public class ClosestNumbers {
    public static void main(String[] args) {
        sort(System.in, System.out);
    }

    public static void sort(InputStream in, PrintStream out) {
        Scanner input = new Scanner(in);
        Integer arrayLength = input.nextInt();
        int[] readValues = new int[arrayLength];
        int resultLength = 0;
        int[] result = new int[arrayLength * 2];    // Since every value can appear twice at most

        readValues[0] = input.nextInt();
        for (int i = 1; i < arrayLength; i++) {
            insertSorted(readValues, i, input.nextInt());
        }

        resultLength = test(readValues, result);

        printResult(out, resultLength, result);
    }

    private static int test(int[] readValues, int[] result) {
        int minDiff = Integer.MAX_VALUE;
        int resultLength = 0;

        for (int i = 1; i < readValues.length; i++) {
            int diff = Math.abs(readValues[i - 1] - readValues[i]);
            if (diff < minDiff) {
                result[0] = readValues[i - 1];
                result[1] = readValues[i];
                resultLength = 2;
                minDiff = diff;
            } else if (diff == minDiff) {
                result[resultLength] = readValues[i - 1];
                result[resultLength + 1] = readValues[i];
                resultLength += 2;
            }
        }
        return resultLength;
    }

    public static int insertSorted(int[] readValues, int elements, int element) {
        int insertPos = elements;
        for (int j = elements - 1; j >= 0; j--) {
            if (readValues[j] > element) {
                readValues[j + 1] = readValues[j];
                readValues[j] = element;
                insertPos = j;
            } else {
                readValues[j + 1] = element;
                insertPos = j + 1;
                break;
            }
        }
        return insertPos;
    }

    private static void printResult(PrintStream out, int resultLength, int[] result) {
        for (int i = 0; i < resultLength - 1; i = i + 2) {
            if (i != 0) {
                out.print(" ");
            }
            out.print(result[i] + " " + result[i + 1]);
        }
    }
}
