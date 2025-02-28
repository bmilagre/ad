package ch.hslu.ad.sw02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackMachineTest {
    private StackMachine stackMachine;

    @BeforeEach
    void setUp() {
        this.stackMachine = new StackMachine();
    }

    @Test
    void testIfAddOperationIsCorrect(){
       this.stackMachine.load(1);
       this.stackMachine.load(2);
       this.stackMachine.add();

       assertEquals(3, this.stackMachine.print());
    }

    @Test
    void testIfSubOperationIsCorrect(){
        this.stackMachine.load(5);
        this.stackMachine.load(2);
        this.stackMachine.sub();

        assertEquals(3, this.stackMachine.print());
    }

    @Test
    void testIfMultOperationIsCorrect(){
        this.stackMachine.load(5);
        this.stackMachine.load(2);
        this.stackMachine.mul();

        assertEquals(10, this.stackMachine.print());
    }

    @Test
    void testIfDivOperationIsCorrect(){
        this.stackMachine.load(14);
        this.stackMachine.load(7);
        this.stackMachine.div();

        assertEquals(2, this.stackMachine.print());
    }

    @Test
    void testIfPrintOperationIsCorrect(){
        this.stackMachine.load(5);
        assertEquals(5, this.stackMachine.print());
    }

    @Test
    void testIfCorrectSolution20IsDisplayed(){
        this.stackMachine.load(2);
        this.stackMachine.load(3);
        this.stackMachine.add();
        this.stackMachine.load(4);
        this.stackMachine.mul();

        assertEquals(20, this.stackMachine.print());
    }

    @Test
    void testIfCorrectSolution45IsDisplayed(){
        this.stackMachine.load(4);
        this.stackMachine.load(5);
        this.stackMachine.add();
        this.stackMachine.load(2);
        this.stackMachine.load(3);
        this.stackMachine.add();
        this.stackMachine.mul();

        assertEquals(45, this.stackMachine.print());
    }

    @Test
    void testIfCorrectSolution10IsDisplayed(){
        this.stackMachine.load(6);
        this.stackMachine.load(7);
        this.stackMachine.load(4);
        this.stackMachine.sub();
        this.stackMachine.div();
        this.stackMachine.load(5);
        this.stackMachine.mul();

        assertEquals(10, this.stackMachine.print());
    }
}