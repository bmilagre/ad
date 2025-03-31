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
 * Demonstration von Bällen.
 */
public final class DemoBalls {

    /**
     * Privater Konstruktor.
     */
    private DemoBalls() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final String[] color = {"red", "black", "blue", "yellow", "green", "magenta"};
        Canvas canvas = Canvas.getCanvas();
        Random random = new Random();

        for(int i = 0; i < 500; i++) {
            int randomColorIndex = random.nextInt(color.length);
            int randomXCoordinate = random.nextInt(600);
            int randomYCoordinate = random.nextInt(10);
            int randomRadius = random.nextInt(50 - 20 + 1) + 20;

            Ball ball = new Ball(randomRadius, randomXCoordinate, randomYCoordinate,  color[randomColorIndex]);
            final Thread thread = new Thread(ball);
            thread.start();

            Thread.startVirtualThread(ball);
        }
    }
}
