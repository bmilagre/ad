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
package ch.hslu.ad.sw06.latch;

/**
 * Eine Synchronisationshilfe, die es ermöglicht, einen oder mehrere Threads warten zu lassen, bis
 * diese durch andere Threads aufgeweckt werden. Latches sperren so lange, bis sie einmal ausgelöst
 * werden. Danach sind sie frei passierbar.
 */
public final class Latch implements Synch {

    private boolean signal;

    /**
     * Erzeugt ein Latch.
     */
    public Latch() {
       this.signal = false;
    }
    
    @Override
    public synchronized void acquire() throws InterruptedException {
        while (!this.signal) {
            wait();
        }
    }

    @Override
    public void release() {
        this.signal = true;

        synchronized (this) {
            notifyAll();
        }
    }
}
