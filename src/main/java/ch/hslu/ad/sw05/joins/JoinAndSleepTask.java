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
package ch.hslu.ad.sw05.joins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parametrierbarer Task, der auf einen fremden Thread wartet und danach für
 * eine bestimmte Zeit schläft.
 */
public class JoinAndSleepTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleepTask.class);
    private final String taskName;
    private Thread joinFor;
    private final int sleepTime;

    /**
     * Erzeugt einen Task mit Namen.
     *
     * @param taskName  der Name des Tasks.
     * @param sleepTime die Zeit in mSec die der Task schläft.
     */
    public JoinAndSleepTask(final String taskName, final int sleepTime, Thread joinFor) {
        this.taskName = taskName;
        this.joinFor = joinFor;
        this.sleepTime = sleepTime;
    }

    /**
     * Hier wird auf das Ende des fremden Threads gewartet und danach für eine
     * bestimmte Zeit geschlafen. Beide Teile können unterbrochen werden.
     */
    @Override
    public void run() {
        LOG.info("Starting " + this.taskName);

        if(this.joinFor != null) {
            try {
                joinFor.join();
                LOG.info("{} will wait for {}", this.taskName, this.joinFor.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            LOG.info("{} will start sleep of {}", this.taskName, this.sleepTime);
            Thread.sleep(this.sleepTime);
        } catch (InterruptedException e) {
            LOG.error("{} was interrupted while waiting", this.taskName);
            Thread.currentThread().interrupt();
        } finally {
            LOG.info("Task {} is done", this.taskName);
        }
    }
}