package Factory.Demography;

import Domain.Demography.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {
    private String testRaceName;

    @Before
    public void setUp() throws Exception {
        this.testRaceName="testRaceName";
    }

    @Test
    public void buildRace() {
        Race course=RaceFactory.buildRace(this.testRaceName);
        Assert.assertNotNull(course.getRaceId());
        Assert.assertNotNull(course);
    }
}