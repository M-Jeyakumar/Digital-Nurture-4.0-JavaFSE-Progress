package Week_1.Design_Patterns_and_Principles.Exercise_1_Implementing_the_Singleton_Pattern;

class Logger{
    private static Logger instance = null;
    public String s;
    private Logger(){
        s = "This is a singleton class";
    }
    public static Logger getInstance(){
        if(instance==null){
            instance = new Logger();
        }
        return instance;
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger o1 = Logger.getInstance();
        Logger o2 = Logger.getInstance();
        Logger o3 = Logger.getInstance();

        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o3.hashCode());

        o1.s = "This will change the values of s in other instances also";

        System.out.println(o2.s);

        if(o1==o2 && o2==o3){
            System.out.println("All three instances are sharing the same memory");
        }
    }
}
