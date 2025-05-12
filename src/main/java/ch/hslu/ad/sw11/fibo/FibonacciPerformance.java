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
package ch.hslu.ad.sw11.fibo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.ForkJoinPool;

/**
 * Performance Vergleich der Fibonacci Implementationen.
 */
public final class FibonacciPerformance {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciPerformance.class);

    /**
     * Privater Konstruktor.
     */
    private FibonacciPerformance() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int numbOfRounds = 5;
        final int n = 42;

        try (final ForkJoinPool pool = new ForkJoinPool()) {
            LOG.info("fibo({}) start...", n);

            long startTime, endTime, result = 0, totalTimeTask = 0, totalTimeIte = 0, totalTimeRec = 0;

            for (int i = 0; i < numbOfRounds; i++) {
                startTime = System.currentTimeMillis();
                final FibonacciTask task = new FibonacciTask(n);
                result = task.invoke();

                endTime = System.currentTimeMillis();

                totalTimeTask += endTime - startTime;
            }

            LOG.info("Conc. recursive = {}", result);
            LOG.info("Conc. recursive : {} ms.", totalTimeTask / numbOfRounds);

            for (int i = 0; i < numbOfRounds; i++) {
                startTime = System.currentTimeMillis();
                result = FibonacciCalc.fiboIterative(n);
                endTime = System.currentTimeMillis();

                totalTimeIte += endTime - startTime;
            }
            LOG.info("Func. iterative = {}", result);
            LOG.info("Func. iterative : {} ms.", totalTimeIte / numbOfRounds);

            for (int i = 0; i < numbOfRounds; i++) {
                startTime = System.currentTimeMillis();
                result = FibonacciCalc.fiboRecursive(n);
                endTime = System.currentTimeMillis();

                totalTimeRec += endTime - startTime;
            }
            LOG.info("Func. recursive = {}", result);
            LOG.info("Func. recursive : {} ms.", totalTimeRec / numbOfRounds);
        }
    }
}
