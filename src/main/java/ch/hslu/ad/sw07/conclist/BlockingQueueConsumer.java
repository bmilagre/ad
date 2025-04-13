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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Konsument, der soviele Integer Werte aus einer BlockingQueue liest, wie er nur kann.
 */
public final class BlockingQueueConsumer implements Callable<Long> {

    private final BlockingQueue<Integer> queue;
    private final int expectedCount;

    /**
     * Erzeugt einen Konsumenten, der soviel Integer-Werte ausliest, wie er nur kann.
     *
     * @param queue Queue zum Lesen der Integer-Werte.
     * @param count Erwartete Anzahl Elemente.
     */
    public BlockingQueueConsumer(final BlockingQueue<Integer> queue, final int count) {
        this.queue = queue;
        this.expectedCount = count;
    }

    /**
     * Liefert die Summe aller ausgelesener Werte.
     *
     * @return Summe.
     * @throws java.lang.Exception falls Ausnahmen passieren.
     */
    @Override
    public Long call() throws Exception {
        long sum = 0;
        int readCount = 0;

        while (readCount < expectedCount) {
            Integer value = queue.poll(5, TimeUnit.SECONDS);
            if (value == null) {
                // Timeout - keine weiteren Elemente verfügbar
                break;
            }
            sum += value;
            readCount++;
        }

        return sum;
    }
}