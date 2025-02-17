package ch.hslu.ad.sw01;

public interface TrainInterface {

    /**
     * Gets the successor of the current Wagon
     * @return Returns the wagon behind the current.
     */
    Wagon getSuccessorWagon();

    /**
     * Sets the successor of the current Wagon
     * @param successorWagon
     */
    void setSuccessorWagon(Wagon successorWagon);

    /**
     * Counts the total number of passengers of the train.
     * @param successorWagon The first wagon of the train.
     * @return The total number of passengers.
     */
    static int calculateTotalPassengers(Wagon successorWagon) {
        int numberOfPassengers = 0;
        Wagon currentWagon = successorWagon;

        while (currentWagon != null) {
            numberOfPassengers += currentWagon.getNumberOfPassengers();
            currentWagon = currentWagon.getSuccessorWagon();
        }

        return numberOfPassengers;
    }
}
