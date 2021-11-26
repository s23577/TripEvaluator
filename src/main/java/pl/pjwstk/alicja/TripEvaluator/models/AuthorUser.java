package pl.pjwstk.alicja.TripEvaluator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuthorUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //po to aby komputer nie mylil id komputera z id komponentu
    private Integer id;
    private String name;
    private int yearsOfExperienceInTravel;
    private boolean anonymousUser;

    public AuthorUser(){
    }

    public AuthorUser(Integer id, String name, int yearsOfExperienceInTravel, boolean anonymousUser) {
        this.id = id;
        this.name = name;
        this.yearsOfExperienceInTravel = yearsOfExperienceInTravel;
        this.anonymousUser = anonymousUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperienceInTravel() {
        return yearsOfExperienceInTravel;
    }

    public void setYearsOfExperienceInTravel(int yearsOfExperienceInTravel) {
        this.yearsOfExperienceInTravel = yearsOfExperienceInTravel;
    }

    public boolean isAnonymousUser() {
        return anonymousUser;
    }

    public void setAnonymousUser(boolean anonymousUser) {
        this.anonymousUser = anonymousUser;
    }

    @Override
    public String toString() {
        return "AuthorUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearsOfExperienceInTravel=" + yearsOfExperienceInTravel +
                ", anonymousUser=" + anonymousUser +
                '}';
    }
}
