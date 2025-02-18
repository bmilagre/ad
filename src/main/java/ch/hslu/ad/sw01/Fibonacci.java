package ch.hslu.ad.sw01;

public class Fibonacci {
    public int fiboRec1(final int n) {
        // Rekursionsbasis
        if (n <= 1) {
            return n;
        }

        // Rekursionvorschrift
        return  fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    public int fiboRec2(final int n, int[] fibSolved) {
        if(fibSolved[n] != 0) {
            return fibSolved[n];
        }

        // Rekursionsbasis
        if (n <= 1) {
            return n;
        }

        // Rekursionvorschrift
        int result = fiboRec2(n - 1, fibSolved) + fiboRec2(n - 2, fibSolved);
        fibSolved[n] = result;
        return result;
    }

    public int fiboIter(final int n) {
        int numberMinusTwo, numberMinusOne = 0, result = 1;

        for (int i = 1; i < n; i++) {
            numberMinusTwo = numberMinusOne;
            numberMinusOne = result;
            result = numberMinusTwo + numberMinusOne;
        }

        return result;
    }
}
