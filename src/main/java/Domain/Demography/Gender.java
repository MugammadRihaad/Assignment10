package Domain.Demography;
import java.util.*;


public class Gender {

    private String genderID ,genderName;
    private Gender(){}

    private Gender(Builder builder) {
        this.genderID = builder.genderId;
        this.genderName = builder.genderName;
    }

    public String getGenderId() {
        return genderID;
    }

    public String getGenderName() {
        return genderName;
    }

    public static class Builder{

        private String genderId, genderName;

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder genderName(String genderName) {
            this.genderName = genderName;
            return this;
        }

        public Builder copy(Gender course){
            this.genderId = course.genderID;
            this.genderName = course.genderName;

            return this;
        }

        public Gender build() {
            return new Gender(this);
        }

    }

    @Override
    public String toString() {
        return "Course{" +
                "genderId='" + genderID + '\'' +
                ", genderName='" + genderName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender course = (Gender) o;
        return genderID.equals(course.genderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderID);
    }


}
