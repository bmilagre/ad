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
package ch.hslu.ad.sw07.prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 100 grosse Primzahlen finden.
 */
public final class PrimeCheck {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheck.class);
    private static final AtomicInteger countPrimes = new AtomicInteger(0);

    /**
     * Privater Konstruktor.
     */
    private PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long time = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        final Callable<Boolean> findPrimeTask = () -> {
            boolean foundPrime = false;

            while (!foundPrime) {
                BigInteger bi = new BigInteger(1024, new Random());
                if (bi.isProbablePrime(Integer.MAX_VALUE)) {
                    LOG.info("{} : {}...", countPrimes.get(), bi.toString().substring(0, 20));
                    countPrimes.incrementAndGet();
                    foundPrime = true;
                }
            }

            return true;
        };

        for (int i = 0; i < 100; i++) {
            executorService.submit(findPrimeTask);
        }

        //ToDo: Fragen
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.HOURS)) {
                LOG.warn("Timeout beim Warten auf Primzahlenberechnung");
            }
        } catch (InterruptedException e) {
            LOG.error("Unterbrochen beim Warten auf Primzahlenberechnung", e);
            Thread.currentThread().interrupt();
        }

        LOG.info("Time taken: {} ms", System.currentTimeMillis() - time);
    }
}
