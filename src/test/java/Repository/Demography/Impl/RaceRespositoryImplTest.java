package Repository.Demography.Impl;

import Domain.Demography.Race;
import Factory.Demography.RaceFactory;
import Repository.Demography.RaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRespositoryImplTest {

    private RaceRepository repository;
    private Race race;

    private Race getSavedRace() {
        Set<Race> savedRaces = this.repository.getAll();
        return savedRaces.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository =  RaceRespositoryImpl.getRepository();
        this.race = RaceFactory.buildRace("Test Race");
    }

    @Test
    public void a_create() {
        Race created = this.repository.create(this.race);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.race);
    }

    @Test
    public void b_read() {
        Race savedRace = getSavedRace();
        System.out.println("In read, raceId = "+ savedRace.getRaceId());
        Race read = this.repository.read(savedRace.getRaceId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedRace, read);
    }

    @Test
    public void e_delete() {
        Race savedRace = getSavedRace();
        this.repository.delete(savedRace.getRaceId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Race Name";
        Race race = new Race.Builder().copy(getSavedRace()).raceName(newname).build();
        System.out.println("In update, about_to_updated = " + race);
        Race updated = this.repository.update(race);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getRaceName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Race> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}