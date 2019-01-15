package alexscotson.forum.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table (name = "topics")
public class Topic {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;

    @NotEmpty
    private User author;

    @NotEmpty
    private String title;

    @NotEmpty
    private String body;

    @NotEmpty
    private Date date = new Date();

    public Topic() {

    }

    public Topic (User author, String title, String message) {
        this.author = author;
        this.title = title;
        this.body = message;
    }

    public Topic (Integer id, User author, String title, String body) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.body = body;
    }


    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", message='" + body + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public User getUser () {
        return author;
    }

    public void setUser (User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBody () {
        return body;
    }

    public void setBody (String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
