package Week_2.TDD_using_JUnit5_and_Mockito.JUnit_Basic_Testing_Exercises.Exercise_4_Arrange_Act_Assert_Pattern_Teardown_methods;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BackAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp(){
        account = new BankAccount("Jeyakumar",1000.0);
        System.out.println("Setup Completed");
    }

    @AfterEach
    void tearDown(){
        account = null;
        System.out.println("Teardown completed");
    }

    @Test
    void testDeposit(){
        account.deposit(500.0);
        assertEquals(1500.0,account.getBalance(),"After deposit balance will be 1500.0");
    }

    @Test
    void testWithdrawSuccess(){
        boolean answer = account.withdraw(300.0);

        assertTrue(answer,"Withdrawal should succeed");
        assertEquals(700.0,account.getBalance(),"After withdrawal balance will be 700.0");
    }

    @Test
    void testWithdrawFailure(){
        boolean answer = account.withdraw(2000.0);

        assertFalse(answer,"Withdrawal should fail");
        assertEquals(1000.0,account.getBalance(),"Balance will be same since we can't withdraw the money");
    }
}
