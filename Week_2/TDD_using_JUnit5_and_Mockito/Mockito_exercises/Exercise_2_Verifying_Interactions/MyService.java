package Week_2.TDD_using_JUnit5_and_Mockito.Mockito_exercises.Exercise_2_Verifying_Interactions;

public class MyService {
    private ExternalApi api;
    public MyService(ExternalApi api){
        this.api = api;
    }
    public String fetchData(){
        return api.getData();
    }
}
