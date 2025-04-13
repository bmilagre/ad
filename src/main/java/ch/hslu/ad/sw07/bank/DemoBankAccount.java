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
package ch.hslu.ad.sw07.bank;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration der Bankgeschäfte - Aufgabe 4 - N3_EX_WeiterführendeKonzepte.
 */
public final class DemoBankAccount {

    private static final Logger LOG = LoggerFactory.getLogger(DemoBankAccount.class);

    /**
     * Privater Konstruktor.
     */
    private DemoBankAccount() {
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

        for(int i = 0; i <= numRuns; i++) {
            final ArrayList<BankAccount> source = new ArrayList<>();
            final ArrayList<BankAccount> target = new ArrayList<>();
            final int amount = 100000;
            final int number = 5;

            long startTime = System.nanoTime();

            for (int z = 0; z < number; z++) {
                source.add(new BankAccount(amount));
                target.add(new BankAccount());
            }
            // Account Tasks starten...
            try (final ExecutorService executor = Executors.newCachedThreadPool()) {
                for (int h = 0; h < number; h++) {
                    executor.submit(new AccountTask(source.get(h), target.get(h), amount));
                }
                executor.shutdown();
            }

            long endTime = System.nanoTime();

            if(i >= 1){
                LOG.info("Bank accounts after transfers");
                LOG.info("Attempt #{} Duration: {} ms", i, (endTime - startTime) / 1000000L);
                totalTime += (endTime - startTime) / 1000000L;
            }
        }

        LOG.info("Average Duration: {} ms", totalTime / numRuns);
    }
}
