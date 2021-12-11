package pl.pjwstk.alicja.TripEvaluator.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //po to aby komputer nie mylil id komputera z id komponentu
    private Integer id;
    private String title;
    private String destination;
    private int daysOfDuration;
    private double commission;
    private MainTypeOfConveyance mainTypeOfConveyance;
    @OneToMany(cascade = CascadeType.ALL) //insert do wszystkich trzech klas/tabel
    private List<Review> reviewList;

    public Trip(){
    }

    public Trip(Integer id, String title, String destination, int daysOfDuration, double commission, MainTypeOfConveyance mainTypeOfConveyance, List<Review> reviewList) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.daysOfDuration = daysOfDuration;
        this.commission = commission;
        this.mainTypeOfConveyance = mainTypeOfConveyance;
        this.reviewList = reviewList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDaysOfDuration() {
        return daysOfDuration;
    }

    public void setDaysOfDuration(int daysOfDuration) {
        this.daysOfDuration = daysOfDuration;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public MainTypeOfConveyance getMainTypeOfConveyance() {
        return mainTypeOfConveyance;
    }

    public void setMainTypeOfConveyance(MainTypeOfConveyance mainTypeOfConveyance) {
        this.mainTypeOfConveyance = mainTypeOfConveyance;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void addToReviewList(Review review) {
        this.reviewList.add(review);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", destination='" + destination + '\'' +
                ", daysOfDuration=" + daysOfDuration +
                ", commission=" + commission +
                ", mainTypeOfConveyance=" + mainTypeOfConveyance +
                ", reviewList=" + reviewList +
                '}';
    }
}
