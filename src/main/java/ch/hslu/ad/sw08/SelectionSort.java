package ch.hslu.ad.sw08;

import ch.hslu.ad.sw07.bank.DemoBankAccount;
import ch.hslu.ad.sw08.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.hslu.ad.sw08.SortingMain.*;

public class SelectionSort {
    private static final Logger LOG = LoggerFactory.getLogger(InsertionSort.class);
    private static final boolean GUI = true;

    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort();
        int[] sizes = {10, 100000, 200000, 400000};
        //int[] sizes = {10};

        for (int size : sizes) {
            int[] numbersShuffle = getShuffledNumbers(size);
            long[] resultShuffle = sorter.measureTimeOfSorting(numbersShuffle);
            LOG.info("Type: getShuffledNumbers, Size: {}, Average Duration: {} ms, Comparisons: {}", size, resultShuffle[0], resultShuffle[1]);

            int[] numbersAsc = getAscendingNumbers(size);
            long[] resultAsc = sorter.measureTimeOfSorting(numbersAsc);
            LOG.info("Type: getAscendingNumbers, Size: {}, Average Duration: {} ms, Comparisons: {}", size, resultAsc[0], resultAsc[1]);

            int[] numbersDesc = getDescendingNumbers(size);
            long[] resultDesc = sorter.measureTimeOfSorting(numbersDesc);
            LOG.info("Type: getDescendingNumbers, Size: {}, Average Duration: {} ms, Comparisons: {}", size, resultDesc[0], resultDesc[1]);
        }
    }

    public static int[] sort(final int[] a) {
        sortWithComparisons(a);
        return a;
    }

    public static long sortWithComparisons(final int[] a) {
        long numbOfComparisons = 0;
        int length = a.length;

        for (int i = 0; i < length - 1; i++) {
            // Search the smallest element in the remaining array
            int minPos = i;
            int min = a[minPos];
            for (int j = i + 1; j < length; j++) {
                if (a[j] < min) {
                    minPos = j;
                    min = a[minPos];

                    if (GUI) {
                        SortingAnimation.instance().showArray(a, 30);
                    }
                }

                numbOfComparisons++;
            }

            // Swap min with element at pos i
            if (minPos != i) {
                a[minPos] = a[i];
                a[i] = min;

                if (GUI) {
                    SortingAnimation.instance().showArray(a, 30);
                }
            }

            numbOfComparisons++;
        }

        return numbOfComparisons;
    }

    private long[] measureTimeOfSorting(final int[] a) {
        long totalTime = 0;
        long totalComparisons = 0;
        int numRuns = 5;

        for (int i = 0; i < numRuns; i++) {
            int[] numbers = a.clone();

            long startTime = System.nanoTime();
            long comparisons = sortWithComparisons(numbers);
            long endTime = System.nanoTime();

            if (i != 0) {
                totalTime += (endTime - startTime) / 1000000L;
                totalComparisons += comparisons;
            }
        }

        return new long[]{totalTime / (numRuns - 1), totalComparisons / (numRuns - 1)};
    }
}