package ch.hslu.ad.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TrainSimulation {

    /* ToDo: Müssen diese auch ins UML? */
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainSimulation.class);

    public static void main(final String[] args) {
        Wagon wagon = new Wagon("W001", 60, new Wagon("W002", 40, new Wagon("W003", 80)));

        int totalPassengers = TrainInterface.calculateTotalPassengers(wagon);
        LOGGER.info("Total Passengers : " + totalPassengers);
    }
}
