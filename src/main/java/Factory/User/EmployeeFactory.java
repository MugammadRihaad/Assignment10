package Factory.User;

import Domain.User.Employee;
import util.Misc;

public class EmployeeFactory {

    public static Employee buildEmployee(String firstName, String lastName, int age){
        return new Employee.Builder()
                            .employeeID(Misc.generateID())
                             .employeeFS(firstName)
                             .employeeLS(lastName)
                             .age(age)
                            .build();
    }
}
