package Repository.Demography.Impl;

import Domain.Demography.Race;
import Repository.Demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRespositoryImpl implements RaceRepository {
    private static RaceRespositoryImpl repository = null;
    private Set<Race> races;

    private RaceRespositoryImpl() {
        this.races = new HashSet<>();
    }

    private Race findRace(String raceId) {
        return this.races.stream()
                .filter(race -> race.getRaceId().trim().equals(raceId))
                .findAny()
                .orElse(null);
    }

    public static RaceRespositoryImpl getRepository() {
        if (repository == null) repository = new RaceRespositoryImpl();
        return repository;
    }


    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    public Race read(final String raceId) {
        Race race = findRace(raceId);
        return race;
    }

    public void delete(String raceId) {
        Race race = findRace(raceId);
        if (race != null) this.races.remove(race);
    }

    public Race update(Race race) {
        Race toDelete = findRace(race.getRaceId());
        if (toDelete != null) {
            this.races.remove(toDelete);
            return create(race);
        }
        return null;
    }


    public Set<Race> getAll() {
        return this.races;
    }
}
