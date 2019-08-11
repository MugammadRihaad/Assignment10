package Service.User;

import Domain.User.Employee;
import Repository.IRepository;

import java.util.Set;

public interface EmployeeService extends IRepository<Employee, String> {
    Set<Employee> getAll();
}
