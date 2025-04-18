/*
 * Copyright 2025 Hochschule Luzern - Informatik.
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
package ch.hslu.ad.sw05.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Demonstration der Bankgeschäfte - Aufgabe 2 - N1_EX_ThreadsSynch.
 */
public final class DemoBankAccount {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBankAccount.class);

    /**
     * Privater Konstruktor.
     */
    private DemoBankAccount() {
    }

    /**
     * Wartet bis alle Threads abgearbeitet sind.
     *
     * @param threads Array mit Threads.
     * @throws InterruptedException Interupted.
     */
    private static void waitForCompletion(final Thread[] threads) throws InterruptedException {
        for (final Thread thread : threads) {
            thread.join();
        }
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn Warten unterbrochen wird.
     */
    public static void main(String[] args) throws InterruptedException {
        int numRuns = 5;
        long totalTime = 0;

        for (int i = 0; i <= numRuns; i++) {

            final ArrayList<BankAccount> source = new ArrayList<>();
            final ArrayList<BankAccount> target = new ArrayList<>();
            final int amount = 100_000;
            final int number = 5;

            long startTime = System.nanoTime();

            for (int z = 0; i < number; z++) {
                source.add(new BankAccount(amount));
                target.add(new BankAccount());
            }
            final Thread[] threads = new Thread[number * 2];
            for (int h = 0; h < number; h++) {
                threads[h] = new Thread(new AccountTask(source.get(h), target.get(h), amount));
                threads[h + number] = new Thread(new AccountTask(target.get(h), source.get(h), amount));
            }
            for (final Thread thread : threads) {
                thread.start();
            }
            waitForCompletion(threads);

            long endTime = System.nanoTime();

            LOG.info("Bank accounts after transfers");
            for (int y = 0; y < number; y++) {
                LOG.info("source({}) = {}; target({}) = {};", y, source.get(y).getBalance(), y, target.get(y).getBalance());
            }
            if (i >= 1) {
                LOG.info("Bank accounts after transfers");
                LOG.info("Attempt #{} Duration: {} ms", i, (endTime - startTime) / 1000000L);
                totalTime += (endTime - startTime) / 1000000L;
            }
        }
    }
}
