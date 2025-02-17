package ch.hslu.ad.sw01;

import java.util.Objects;

public class Wagon implements TrainInterface {
    private final String identifier;
    private final int numberOfPassengers;
    private Wagon successorWagon = null;

    public Wagon(String identifier, int numberOfPassengers) {
        this.identifier = identifier;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Wagon(String identifier, int numberOfPassengers, Wagon successorWagon) {
        this.identifier = identifier;
        this.numberOfPassengers = numberOfPassengers;
        this.successorWagon = successorWagon;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getNumberOfPassengers() {
        return this.numberOfPassengers;
    }

    @Override
    public Wagon getSuccessorWagon() {
        return this.successorWagon;
    }

    @Override
    public void setSuccessorWagon(Wagon successorWagon) {
        this.successorWagon = successorWagon;
    }

    /* ToDo: Müssen diese auch ins UML? */
    @Override
    public final boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Wagon wagon)) {
            return false;
        }

        return Objects.equals(this.identifier, wagon.getIdentifier()) && Objects.equals(this.numberOfPassengers, wagon.getNumberOfPassengers());
    }

    /* ToDo: Müssen diese auch ins UML? */
    @Override
    public final int hashCode() {
        return Objects.hash(this.identifier, this.numberOfPassengers);
    }
}
