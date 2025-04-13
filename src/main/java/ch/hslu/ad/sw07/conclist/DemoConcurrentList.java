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
package ch.hslu.ad.sw07.conclist;

import java.util.*;
import java.util.concurrent.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration einer synchronisierten List mit n Producer und m Consumer.
 */
public final class DemoConcurrentList {

    private static final Logger LOG = LoggerFactory.getLogger(DemoConcurrentList.class);
    private static final int NUM_PRODUCERS = 3;
    private static final int MAX_RANGE = 1000;

    /**
     * Privater Konstruktor.
     */
    private DemoConcurrentList() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das warten unterbrochen wird.
     * @throws java.util.concurrent.ExecutionException bei Excecution-Fehler.
     */
    public static void main(final String args[]) throws InterruptedException, ExecutionException {
        LOG.info("Test mit unsynchronisierter Liste:");
        testWithUnsynchronizedList();

        LOG.info("Test mit synchronisierter Liste:");
        testWithSynchronizedList();

        LOG.info("Test mit BlockingQueue:");
        testWithBlockingQueue();
    }

    /**
     * Test mit einer unsynchronisierten Liste.
     */
    private static void testWithUnsynchronizedList() throws InterruptedException, ExecutionException {
        try {
            final Random random = new Random();
            final List<Integer> list = new LinkedList<>();
            final long startTime = System.currentTimeMillis();

            final List<Future<Long>> futures = new ArrayList<>();
            try (final ExecutorService executor = Executors.newCachedThreadPool()) {
                // Produzenten starten
                for (int i = 0; i < NUM_PRODUCERS; i++) {
                    futures.add(executor.submit(new Producer(list, random.nextInt(MAX_RANGE))));
                }

                // Produzenten auswerten
                long totProd = 0;
                for (Future<Long> future : futures) {
                    long sum = future.get();
                    totProd += sum;
                    LOG.info("Produzent Summe: " + sum);
                }
                LOG.info("Produzenten Gesamtsumme: " + totProd);

                // Konsument starten
                long totCons = executor.submit(new Consumer(list)).get();
                LOG.info("Konsument Summe: " + totCons);
                LOG.info("Sind Summen gleich? " + (totProd == totCons));

                final long duration = System.currentTimeMillis() - startTime;
                LOG.info("Laufzeit: " + duration + " ms");
            }
        } catch (Exception e) {
            LOG.error("Fehler aufgetreten: " + e.getMessage());
        }
        LOG.info("-----------------------------------");
    }

    /**
     * Test mit einer synchronisierten Liste.
     */
    private static void testWithSynchronizedList() throws InterruptedException, ExecutionException {
        final Random random = new Random();
        final List<Integer> list = Collections.synchronizedList(new LinkedList<>());
        final long startTime = System.currentTimeMillis();

        final List<Future<Long>> futures = new ArrayList<>();
        try (final ExecutorService executor = Executors.newCachedThreadPool()) {
            // Produzenten starten
            for (int i = 0; i < NUM_PRODUCERS; i++) {
                futures.add(executor.submit(new Producer(list, random.nextInt(MAX_RANGE))));
            }

            // Produzenten auswerten
            long totProd = 0;
            for (Future<Long> future : futures) {
                long sum = future.get();
                totProd += sum;
                LOG.info("Produzent Summe: " + sum);
            }
            LOG.info("Produzenten Gesamtsumme: " + totProd);

            // Konsument starten
            long totCons = executor.submit(new Consumer(list)).get();
            LOG.info("Konsument Summe: " + totCons);
            LOG.info("Sind Summen gleich? " + (totProd == totCons));

            final long duration = System.currentTimeMillis() - startTime;
            LOG.info("Laufzeit: " + duration + " ms");
        }
        LOG.info("-----------------------------------");
    }

    /**
     * Test mit einer BlockingQueue.
     */
    private static void testWithBlockingQueue() throws InterruptedException, ExecutionException {
        final Random random = new Random();
        final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        final long startTime = System.currentTimeMillis();

        final List<Future<Long>> futures = new ArrayList<>();
        try (final ExecutorService executor = Executors.newCachedThreadPool()) {
            // Gesamtzahl der Elemente für den Consumer
            int totalElements = 0;

            // Produzenten starten
            for (int i = 0; i < NUM_PRODUCERS; i++) {
                int range = random.nextInt(MAX_RANGE);
                totalElements += range;
                futures.add(executor.submit(new BlockingQueueProducer(queue, range)));
            }

            // Produzenten auswerten
            long totProd = 0;
            for (Future<Long> future : futures) {
                long sum = future.get();
                totProd += sum;
                LOG.info("Produzent Summe: " + sum);
            }
            LOG.info("Produzenten Gesamtsumme: " + totProd);

            // Konsument starten
            long totCons = executor.submit(new BlockingQueueConsumer(queue, totalElements)).get();
            LOG.info("Konsument Summe: " + totCons);
            LOG.info("Sind Summen gleich? " + (totProd == totCons));

            final long duration = System.currentTimeMillis() - startTime;
            LOG.info("Laufzeit: " + duration + " ms");
        }
        LOG.info("-----------------------------------");
    }
}