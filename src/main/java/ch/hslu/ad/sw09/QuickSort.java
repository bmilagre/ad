package ch.hslu.ad.sw09;

import ch.hslu.ad.sw08.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.hslu.ad.sw09.SortingMain.*;

public class QuickSort {
    private static final Logger LOG = LoggerFactory.getLogger(QuickSort.class);
    private static final boolean GUI = false;
    private static long comparisons;

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] sizes = {10000, 30000, 60000};

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
        comparisons = 0;
        quicksort(a, 0, a.length - 1);
        return a;
    }

    public static long sortWithComparisons(final int[] a) {
        comparisons = 0;
        quicksort(a, 0, a.length - 1);
        return comparisons;
    }

    private static int[] quicksort(int[] a, int start, int end) {
        if (start < end) {
            comparisons++;
            int p = partition(a, start, end);
            quicksort(a, start, p - 1);
            quicksort(a, p + 1, end);
        }
        return a;
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            comparisons++;
            if (a[j] <= pivot) {
                i++;

                int swapTemp = a[i];
                a[i] = a[j];
                a[j] = swapTemp;

                if (GUI) {
                    SortingAnimation.instance().showArray(a, 30);
                }
            }
        }

        int swapTemp = a[i + 1];
        a[i + 1] = a[end];
        a[end] = swapTemp;

        if (GUI) {
            SortingAnimation.instance().showArray(a, 30);
        }

        return i + 1;
    }

    private long[] measureTimeOfSorting(final int[] a) {
        long totalTimeNanos = 0;
        long totalComparisons = 0;
        int numRuns = 5;

        for (int i = 0; i < numRuns; i++) {
            int[] numbers = a.clone();

            long startTime = System.nanoTime();
            long comparisonsPerRun = sortWithComparisons(numbers);
            long endTime = System.nanoTime();

            if (i != 0) {
                totalTimeNanos += (endTime - startTime);
                totalComparisons += comparisonsPerRun;
            }
        }

        return new long[]{
                totalTimeNanos / (numRuns - 1) / 1000000L,
                totalComparisons / (numRuns - 1)
        };
    }


}