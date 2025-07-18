/*
 * Copyright 2025 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw11.quicksort;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
public final class QuicksortRecursive {

    /**
     * Privater Konstruktor.
     */
    private QuicksortRecursive() {
    }

    /**
     * public method exposed to client, sorts given array using QuickSort
     * Algorithm in Java.
     *
     * @param array input array.
     */
    public static void quicksort(int[] array) {
        QuicksortRecursive.quicksort(array, 0, array.length - 1);
    }

    /**
     * Recursive quicksort logic.
     *
     * @param array input array.
     * @param startIdx start index of the array.
     * @param endIdx end index of the array.
     */
    public static void quicksort(int[] array, int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, startIdx, endIdx);

            // Recursively sort elements before and after partition
            quicksort(array, startIdx, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, endIdx);
        }
    }

    /**
     * Divides array from pivot, left side contains elements less than Pivot
     * while right side contains elements greater than pivot.
     *
     * @param array array to partitioned.
     * @param left lower bound of the array.
     * @param right upper bound of the array.
     * @return the partition index.
     */
    public static int partition(int[] array, int left, int right) {
        // Choose the last element as pivot
        int pivot = array[left];

        // Pointer for the greater element
        int i = left - 1;

        // Traverse through all elements
        // If element is smaller than or equal to pivot, swap it
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;

                // Swap elements at i and j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the element at i+1
        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        // Return the partition index
        return i + 1;
    }

    private static void exchange(final int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
