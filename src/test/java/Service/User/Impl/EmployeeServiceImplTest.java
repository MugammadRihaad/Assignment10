package Service.User.Impl;

import Domain.User.Employee;
import Factory.User.EmployeeFactory;
import Repository.User.Impl.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImplTest {

    private EmployeeRepositoryImpl repository;
    private Employee employee;

    private Employee getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (EmployeeRepositoryImpl) EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("Rihaad", "Van blerck", 23);
    }

    @Test
    public void a_create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void c_update() {
        String newEmployeeName = "Rihaad";
        Employee updated = new Employee.Builder().copy(getSaved()).employeeFS(newEmployeeName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newEmployeeName, updated.getEmployeeFN());
    }

    @Test
    public void e_delete() {
        Employee saved = getSaved();
        this.repository.delete(saved.getEmployeeID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Employee saved = getSaved();
        Employee read = this.repository.read(saved.getEmployeeID());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Employee> employees = this.repository.getAll();
        System.out.println("In getall, all = " + employees);
    }
}