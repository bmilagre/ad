package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import static ch.hslu.ad.sw08.SortingMain.getShuffledNumbers;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void checkIfArrayIsSortedAscending() {
        int[] result = InsertionSort.sort(getShuffledNumbers(50));
        boolean isCorrectOrder = true;

        for (int i = 0; i < result.length; i++) {
            if(result[i] != result.length && result[i] > result[i + 1]) {
                isCorrectOrder = false;
            }
        }

        assertTrue(isCorrectOrder);
    }
}