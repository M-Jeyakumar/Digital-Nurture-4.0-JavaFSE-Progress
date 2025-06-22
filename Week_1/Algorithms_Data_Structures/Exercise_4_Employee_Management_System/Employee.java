package Week_1.Algorithms_Data_Structures.Exercise_4_Employee_Management_System;

public class Employee {
    int employeeId;
    String employeeName;
    String position;
    int salary;
    public Employee(int employeeId,String employeeName,String position,int salary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.position = position;
        this.salary = salary;
    }

    public String toString(){
        return employeeId+" "+employeeName+" "+position+" "+salary;
    }
}
