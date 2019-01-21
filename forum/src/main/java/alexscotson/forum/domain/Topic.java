package alexscotson.forum.domain;


import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    private String byUser;

    @NotEmpty
    private String topicTitle;

    @NotEmpty
    private String topicBody;

    private String date;

    public Topic() {

    }

    public Topic(@NotEmpty String topicTitle, @NotEmpty String
            topicBody) {
        this.topicTitle = topicTitle;
        this.topicBody = topicBody;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getByUser() {
        return byUser;
    }

    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicBody() {
        return topicBody;
    }

    public void setTopicBody(String topicBody) {
        this.topicBody = topicBody;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "topic{" +
                "id=" + id +
                ", byUser='" + byUser + '\'' +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicBody='" + topicBody + '\'' +
                ", date=" + date +
                '}';
    }
}
