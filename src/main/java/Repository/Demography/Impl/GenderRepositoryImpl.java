package Repository.Demography.Impl;

import Domain.Demography.Gender;
import Repository.Demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {
    private static GenderRepositoryImpl repository= null;
    private Set<Gender> genders;

    private GenderRepositoryImpl(){
        this.genders=new HashSet<>();
    }

    private Gender findGender(String genderID){
        return this.genders.stream()
                            .filter(gender ->gender.getGenderId().trim().equals(genderID))
                            .findAny()
                            .orElse(null);
    }

    public static GenderRepositoryImpl getRepository(){
        if(repository ==null) repository= new GenderRepositoryImpl();
        return repository;
    }

    public Gender create(Gender gender){
        this.genders.add(gender);
        return  gender;
    }

    public Gender read(final String genderId){
        Gender gender = findGender(genderId);
        return gender;
    }

    public void delete(String genderId) {
        Gender gender = findGender(genderId);
        if (gender != null) this.genders.remove(gender);
    }

    public Gender update(Gender gender){
        Gender toDelete = findGender(gender.getGenderId());
        if(toDelete != null) {
            this.genders.remove(toDelete);
            return create(gender);
        }
        return null;
    }


    public Set<Gender> getAll(){
        return this.genders;
    }



}
