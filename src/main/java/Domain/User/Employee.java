package Domain.User;

import java.util.*;
public class Employee {

    private String employeeID, employeeFN,employeeLS;
    private int age;

    private Employee(){}

    private Employee(Builder builder)
    {
    this.employeeID=builder.employeeID;
    this.employeeFN=builder.employeeFN;
    this.employeeLS=builder.employeeLS;
    this.age=builder.age;




    }


    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeFN() {
        return employeeFN;
    }

    public String getEmployeeLS() {
        return employeeLS;
    }

    public int getAge() {
        return age;
    }

        public static class Builder{
        private String employeeID, employeeFN,employeeLS;
        private int age;

        public Builder employeeID(String employeeID){
            this.employeeID=employeeID;
            return this;
        }

        public Builder employeeFS(String employeeFN){
            this.employeeFN=employeeFN;
            return this;
        }

        public Builder employeeLS(String employeeLS){
            this.employeeLS=employeeLS;
            return this;
        }

        public Builder age(int age){
            this.age=age;
            return this;
        }

        public Builder copy(Employee employee){
            this.employeeID=employee.employeeID;
            this.employeeFN=employee.employeeFN;
            this.employeeLS=employee.employeeLS;

            return this;
        }

        public Employee build(){
            return new Employee(this);
        }

        }

        @Override
    public String toString(){
        return "Student{" +
                "EmployeeID='" + employeeID + '\'' +
                ", EmployeeFirstName='" + employeeFN + '\'' +
                ", EmployeeLastName='" + employeeLS + '\'' +
                ", age=" + age +
                '}';
        }

        @Override
    public boolean equals(Object o){
        if(this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return employeeID.equals(employee.employeeID);
        }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }
}
