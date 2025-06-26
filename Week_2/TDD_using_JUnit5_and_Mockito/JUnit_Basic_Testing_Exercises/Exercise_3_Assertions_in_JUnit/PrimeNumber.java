package Week_2.TDD_using_JUnit5_and_Mockito.JUnit_Basic_Testing_Exercises.Exercise_3_Assertions_in_JUnit;

public class PrimeNumber {
    public boolean isPrime(int n){
        if(n<2)return false;
        if(n==2)return true;
        for(int i=2;i*i<n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
