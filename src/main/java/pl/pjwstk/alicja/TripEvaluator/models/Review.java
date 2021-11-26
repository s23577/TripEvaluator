package pl.pjwstk.alicja.TripEvaluator.models;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //po to aby komputer nie mylil id komputera z id komponentu
    private Integer id;
    private String content;
    @ManyToOne(cascade = CascadeType.ALL)
    private AuthorUser authorUser;
    private int rating; //from 0 to 5

    public Review(){
    }

    public Review(Integer id, String content, AuthorUser authorUser, int rating) {
        this.id = id;
        this.content = content;
        this.authorUser = authorUser;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AuthorUser getAuthorUser() {
        return authorUser;
    }

    public void setAuthorUser(AuthorUser authorUser) {
        this.authorUser = authorUser;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", authorUser=" + authorUser +
                ", rating=" + rating +
                '}';
    }
}
