package Factory.User;

import Domain.User.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {

    private String testFN,testLS;
    private int testAge;

    @Before
    public void setUp() throws Exception {
        this.testFN="testFirstName";
        this.testLS="testLastName";
        this.testAge=25;
    }

    @Test
    public void buildEmployee() {

        Employee course = EmployeeFactory.buildEmployee(this.testFN, this.testLS, this.testAge);
        Assert.assertNotNull(course.getEmployeeID());
        Assert.assertNotNull(course);
    }
}