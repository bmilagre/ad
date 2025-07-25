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
package ch.hslu.ad.sw11.mergesort;

import java.util.Arrays;

/**
 * Codebeispiel zu Mergesort für die Sortierung eines int-Arrays.
 */
public final class MergesortRecursive {

    private static int[] array;

    private MergesortRecursive() {
    }

    /**
     * Sortiert ein int-Array mit dem Mergesort-Algorithmus.
     * @param a int-Array zum Sortieren
     */
    public static void mergeSort(final int[] a) {
        array = new int[a.length]; // zusätzlicher Speicher fürs Mergen
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * Interner Mergesort mit Ober- und Untergrenze.
     * @param a int-Array zum Sortieren.
     * @param left Linke Grenze.
     * @param right Rechte Grenze.
     */
    private static void mergeSort(final int a[], final int left, final int right) {
        int i, j, k, m;
        if (right > left) {
            m = (right + left) / 2; // Mitte ermitteln
            mergeSort(a, left, m); // linke Hälfte sortieren
            mergeSort(a, m + 1, right); // rechte Hälfte sortieren
            // "Mergen"
            for (i = left; i <= m; i++) { // linke Hälfte in Hilfsarray kopieren
                array[i] = a[i];
            }
            for (j = m; j < right; j++) { // rechte Hälfte umgekehrt in Hilfsa. kopieren
                array[right + m - j] = a[j + 1];
            }
            i = left;
            j = right; // Index für linke und rechte Hälfte
            for (k = left; k <= right; k++) { // füge sortiert in a ein
                if (array[i] <= array[j]) {
                    a[k] = array[i];
                    i++;
                } else {
                    a[k] = array[j];
                    j--;
                }
            }
        }
    }

    /**
     * Sortiert einen Bereich eines int-Array mit dem Mergesort-Algorithmus. Der
     * Bereich wird durch die linke und rechte Grenze festgelegt.
     *
     * @param a int-Array zum Sortieren.
     * @param min Linke Grenze.
     * @param max Rechte Grenze.
     */
    public static void mergeSortPart(final int a[], final int min, final int max) {
        if ((max - min) > 1) {
            final int mid = min + (max - min) / 2;
            mergeSortPart(a, min, mid); // linke Hälfte sortieren
            mergeSortPart(a, mid, max); // rechte Hälfte sortieren
            merge(a, min, mid, max);
        }
    }

    private static void merge(final int a[], final int min, int mid, int max) {
        // vordere Hälfte von array in Hilfsarray buf kopieren
        int[] buf = Arrays.copyOfRange(a, min, mid);
        int i = 0;
        int j = min;
        int k = mid;
        while (i < buf.length) {
            // jeweils das nächstgrösste Element zurückkopieren
            // bei k == max, Rest von buf zurückkopieren, falls vorhanden
            if (k == max || buf[i] < a[k]) {
                a[j] = buf[i];
                i++;
            } else {
                a[j] = a[k];
                k++;
            }
            j++;
        }
    }
}
