package Week_2.TDD_using_JUnit5_and_Mockito.JUnit_Basic_Testing_Exercises.Exercise_3_Assertions_in_JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeNumberTest {
    PrimeNumber primeChecker = new PrimeNumber();
    String sNull = null;
    String s = "Jeyakumar";

    @Test
    void testPrimeTrue(){
        assertTrue(primeChecker.isPrime(5),"5 is a prime number");
    }

    @Test
    void testPrimeFalse(){
        assertFalse(primeChecker.isPrime(10),"10 is not a prime number");
    }

    @Test
    void testEqual(){
        assertEquals(50,5*10,"5*10 is equal to 50");
    }

    @Test
    void testNull(){
        assertNull(sNull,"sNull is a null value");
    }

    @Test
    void testNotNull(){
        assertNotNull(s,"S is assigned to a value");
    }

}
