package Factory.Demography;

import Domain.Demography.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    private String testGender;

    @Before
    public void setUp() throws Exception {
        this.testGender="TestGender";
    }

    @Test
    public void buildGender() {
        Gender course =GenderFactory.buildGender(this.testGender);
        Assert.assertNotNull(course.getGenderId());
        Assert.assertNotNull(course);
    }
}