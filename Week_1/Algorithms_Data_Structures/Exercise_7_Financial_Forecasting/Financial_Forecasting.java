package Week_1.Algorithms_Data_Structures.Exercise_7_Financial_Forecasting;

public class Financial_Forecasting {

    public static double futureValue(double currentValue,double growthRate,int year){
        if(year==0)return currentValue;
        return futureValue(currentValue*(1+growthRate),growthRate,year-1);
    }

    public static void main(String[] args) {
        double currentValue = 1500.0;
        double growthRate = 0.16;
        int years = 7;
        double futureVal = futureValue(currentValue,growthRate,years);
        System.out.printf("Future value after %d years is %.2f",years,futureVal);
    }
}
