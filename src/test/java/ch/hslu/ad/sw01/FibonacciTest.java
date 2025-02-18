package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {
    private Fibonacci fibonacci = new  Fibonacci();

    @Test
    void testFibo1Rec1WithNumber1(){
        assertThat(fibonacci.fiboRec1(1)).isEqualTo(1);
    }

    @Test
    void testFibo1Rec1WithNumber3(){
        assertThat(fibonacci.fiboRec1(3)).isEqualTo(2);
    }

    @Test
    void testFibo1Rec1WithNumber12(){
        assertThat(fibonacci.fiboRec1(12)).isEqualTo(144);
    }

    @Test
    void testFibo1Rec1WithNumber32(){
        assertThat(fibonacci.fiboRec1(32)).isEqualTo(2178309);
    }

    @Test
    void testFibo2Rec1WithNumber1(){
        assertThat(fibonacci.fiboRec2(1, new int[2])).isEqualTo(1);
    }

    @Test
    void testFibo2Rec1WithNumber3(){
        assertThat(fibonacci.fiboRec2(3, new int[4])).isEqualTo(2);
    }

    @Test
    void testFibo2Rec1WithNumber12(){
        assertThat(fibonacci.fiboRec2(12, new int[13])).isEqualTo(144);
    }

    @Test
    void testFibo2Rec1WithNumber32(){
        assertThat(fibonacci.fiboRec2(32, new int[33])).isEqualTo(2178309);
    }

    @Test
    void testFiboIterWithNumber1(){
        assertThat(fibonacci.fiboIter(1)).isEqualTo(1);
    }

    @Test
    void testFiboIterWithNumber3(){
        assertThat(fibonacci.fiboIter(3)).isEqualTo(2);
    }

    @Test
    void testFiboIterWithNumber12(){
        assertThat(fibonacci.fiboIter(12)).isEqualTo(144);
    }

    @Test
    void testFiboIterWithNumber32(){
        assertThat(fibonacci.fiboIter(32)).isEqualTo(2178309);
    }
}