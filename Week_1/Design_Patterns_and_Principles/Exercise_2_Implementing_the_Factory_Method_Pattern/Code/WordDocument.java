package Week_1.Design_Patterns_and_Principles.Exercise_2_Implementing_the_Factory_Method_Pattern.Code;

public class WordDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening word Document....!");
    }
}
