package Week_1.Algorithms_Data_Structures.Exercise_4_Employee_Management_System;

public class EmployeeManagementSystem {
    private Employee[] employees;
    int ptr;
    public EmployeeManagementSystem(int size){
        this.employees = new Employee[size];
        this.ptr = -1;
    }

    public void addEmployee(int id,String name, String position,int salary){
        employees[++ptr] = new Employee(id,name,position,salary);
    }

    public void search(int employeeId){
        for (int i=0;i<=ptr;i++){
            if(employees[i].employeeId==employeeId){
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("No records found");
    }

    public void traverse(){
        for (int i=0;i<=ptr;i++){
            System.out.println(employees[i]);
        }
    }

    public void delete(int employeeId){
        for(int i=0;i<=ptr;i++){
            if(employees[i].employeeId==employeeId){
                for(int j=i;j<ptr;j++){
                    employees[j] = employees[j+1];
                }
                employees[ptr--] = null;
                System.out.println("Employee data deleted");
                return;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem employees = new EmployeeManagementSystem(100);
        employees.addEmployee(1,"Jeyakumar","Software Developer",80000);
        employees.addEmployee(2,"Kathir","Developer",75000);
        employees.addEmployee(5,"Shriram","Data Scientist",60000);
        employees.addEmployee(3,"Muthu","Developer",75000);

        System.out.println("Datas: ");
        employees.traverse();

        System.out.println("\n Searching Operation:");
        employees.search(3);

        System.out.println("\n After Deletion: ");
        employees.delete(5);
        employees.traverse();
    }
}
