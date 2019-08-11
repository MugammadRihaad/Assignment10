package Domain.Demography;

import java.util.Objects;

public class Race {
    private String raceID,raceName;

    private Race(){}

    private Race(Builder builder) {
        this.raceID = builder.raceId;
        this.raceName = builder.raceName;
    }

    public String getRaceId() {
        return raceID;
    }

    public String getRaceName() {
        return raceName;
    }

    public static class Builder{

        private String raceId, raceName;

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder raceName(String raceName) {
            this.raceName = raceName;
            return this;
        }

        public Builder copy(Race race){
            this.raceId = race.raceID;
            this.raceName = race.raceName;

            return this;
        }

        public Race build() {
            return new Race(this);
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "raceId='" + raceID + '\'' +
                ", raceName='" + raceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return raceID.equals(race.raceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceID);
    }
}
