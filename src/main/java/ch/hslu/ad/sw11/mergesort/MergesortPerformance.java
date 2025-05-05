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

import ch.hslu.ad.sw11.array.init.RandomInitTask;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Performance Vergleich der Mergesort Implementationen.
 */
public final class MergesortPerformance {

    private static final Logger LOG = LoggerFactory.getLogger(MergesortPerformance.class);

    private static final int NUMBER_OF_RUNS = 5;

    /**
     * Privater Konstruktor.
     */
    private MergesortPerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 300_000_000;
        final int[] arrayOriginal = new int[size];
        final int[] thresholds = {10, 15, 30 , 60, 600, 6000, 60000, 600000, 6000000};


        try (final ForkJoinPool pool = new ForkJoinPool()) {
            long totalTimeConc, startTime, endTime, totalTimeRec, totalTimeParal;
            RandomInitTask initTask = new RandomInitTask(arrayOriginal, 100);
            pool.invoke(initTask);
            int[] array;

            for(int t : thresholds) {
                totalTimeConc = 0;
                for (int i = 0; i < NUMBER_OF_RUNS; i++) {
                    array = Arrays.copyOf(arrayOriginal, size);

                    startTime = System.currentTimeMillis();
                    final MergesortTask sortTask = new MergesortTask(array, t);
                    pool.invoke(sortTask);
                    endTime = System.currentTimeMillis();

                    totalTimeConc += endTime - startTime;
                }

                LOG.info("Conc. Mergesort with threshold: {} -> {} ms.", t, (totalTimeConc / NUMBER_OF_RUNS));
            }

            totalTimeRec = 0;
            for (int i = 0; i < NUMBER_OF_RUNS; i++) {
                array = Arrays.copyOf(arrayOriginal, size);

                startTime = System.currentTimeMillis();
                MergesortRecursive.mergeSort(array);
                endTime = System.currentTimeMillis();

                totalTimeRec += endTime - startTime;
            }

            LOG.info("MergesortRec.   : {} ms.", (totalTimeRec / NUMBER_OF_RUNS));

            totalTimeParal = 0;
            for (int i = 0; i < NUMBER_OF_RUNS; i++) {
                array = Arrays.copyOf(arrayOriginal, size);

                startTime = System.currentTimeMillis();
                Arrays.parallelSort(array);
                endTime = System.currentTimeMillis();

                totalTimeParal += endTime - startTime;
            }

            LOG.info("ParallelSort    : {} ms.", (totalTimeParal / 5));
        } finally {
            // Executor shutdown
        }
    }
}
