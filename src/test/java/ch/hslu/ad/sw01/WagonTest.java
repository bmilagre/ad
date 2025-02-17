package ch.hslu.ad.sw01;

import static org.assertj.core.api.Assertions.assertThat;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WagonTest {
    private Wagon wagon1;
    private Wagon wagon2;
    private Wagon wagon3;

    @BeforeEach
    void setUp() {
        wagon3 = new Wagon("W003", 80);
        wagon2 = new Wagon("W002", 40, wagon3);
        wagon1 = new Wagon("W001", 60, wagon2);
    }

    @Test
    void testGetIdentifier() {
        assertThat(wagon1.getIdentifier()).isEqualTo("W001");
    }

    @Test
    void testGetNumberOfPassengers() {
        assertThat(wagon2.getNumberOfPassengers()).isEqualTo(40);
    }

    @Test
    void testGetSuccessorWagon() {
        assertThat(wagon1.getSuccessorWagon()).isEqualTo(wagon2);
    }

    @Test
    void testSetSuccessorWagon() {
        Wagon newWagon = new Wagon("W004", 50);
        wagon3.setSuccessorWagon(newWagon);
        assertThat(wagon3.getSuccessorWagon()).isEqualTo(newWagon);
    }

    @Test
    void testCalculateTotalPassengers() {
        int totalPassengers = TrainInterface.calculateTotalPassengers(wagon1);
        assertThat(totalPassengers).isEqualTo(180);
    }

    @Test
    void testEqualsAndHashCode() {
        EqualsVerifier.simple().forClass(Wagon.class).withIgnoredFields("successorWagon").withPrefabValues(Wagon.class, new Wagon("X001", 10), new Wagon("X002", 20)).verify();
    }
}
