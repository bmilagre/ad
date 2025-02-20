package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AckermannTest {
    private Ackermann ackermann = new Ackermann();


    @Test
    void testAckermannWithValuesZeroAndFour(){
        assertThat(ackermann.ack(0,4)).isEqualTo(5L);
    }

    @Test
    void testAckermannWithValuesOneAndTwo(){
        assertThat(ackermann.ack(1,2)).isEqualTo(4L);
    }

    @Test
    void testAckermannWithValuesTwoAndTwo(){
        assertThat(ackermann.ack(2,2)).isEqualTo(7L);
    }
}