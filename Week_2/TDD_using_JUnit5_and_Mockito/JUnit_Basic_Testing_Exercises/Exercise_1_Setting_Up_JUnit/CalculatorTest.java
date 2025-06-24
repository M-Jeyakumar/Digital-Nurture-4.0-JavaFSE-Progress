package Week_2.TDD_using_JUnit5_and_Mockito.JUnit_Basic_Testing_Exercises.Exercise_1_Setting_Up_JUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    void testAdd(){
        assertEquals(20,calculator.add(15,5));
    }

    @Test
    void testMultiply(){
        assertEquals(20,calculator.multiply(5,4));
    }

    @Test
    void testSubtract(){
        assertEquals(-10,calculator.subtract(0,10));
    }

    @Test
    void testDivide(){
        assertEquals(50,calculator.divide(200,4));
    }
}
