package Repository.User.Impl;

import Domain.User.Employee;
import Repository.User.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static EmployeeRepositoryImpl repository=null;
    private Map<String, Employee> employees;

    private EmployeeRepositoryImpl(){
        this.employees=new HashMap<>();
    }

    public static EmployeeRepository getRepository(){
        if(repository == null) repository=new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee create(Employee employee){
        this.employees.put(employee.getEmployeeID(),employee);
        return employee;
    }

    public Employee read(String employeeID){
        return this.employees.get(employeeID);
    }

    public Employee update(Employee employee){
        this.employees.replace(employee.getEmployeeID(),employee);
        return this.employees.get(employee.getEmployeeID());
    }

    public void delete(String employeeID){
        this.employees.remove(employeeID);
    }

    public Set<Employee> getAll(){
        Collection<Employee> students =this.employees.values();
        Set<Employee> set =new HashSet<>();
        set.addAll(students);
        return set;
    }

}
