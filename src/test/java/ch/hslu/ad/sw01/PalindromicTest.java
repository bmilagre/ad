package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromicTest {
    private Palindromic palindromic = new Palindromic();

    @Test
    void testPalindromicWithNumber7(){
        assertTrue(palindromic.palindromic(7));
    }

    @Test
    void testPalindromicWithNumber8227228(){
        assertTrue(palindromic.palindromic(8227228));
    }

    @Test
    void testPalindromicWithNumber333(){
        assertTrue(palindromic.palindromic(333));
    }

    @Test
    void testPalindromicWithNumber2345(){
        assertFalse(palindromic.palindromic(2345));
    }

    @Test
    void testPalindromicWithNumber12(){
        assertFalse(palindromic.palindromic(12));
    }
}