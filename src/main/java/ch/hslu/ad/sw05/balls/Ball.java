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
package ch.hslu.ad.sw05.balls;

import java.awt.*;
import java.util.Random;

/**
 * Description of class Ball
 */
public final class Ball implements Runnable {

    private final Circle circle;
    private final int size;
    private final int offset;

    /**
     * Erzeugt einen Ball mit gegebenen Parametern Grösse, Position und Farbe.
     *
     * @param size  Grösse des Balls.
     * @param xPos  X-Position des Balls.
     * @param yPos  Y-Position des Balls.
     * @param color Farbe des Balls.
     */
    public Ball(final int size, final int xPos, final int yPos, String color) {
        this.size = 0;
        this.circle = new Circle(size, xPos, yPos, color);
        this.offset = 0;

        this.circle.makeVisible();
    }

    @Override
    public void run() {
        Random random = new Random();

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);

                while(this.circle.getY() < 400) {
                    this.circle.slowMoveVertical(random.nextInt(20));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                Thread.yield();
            }
        }
    }
}
