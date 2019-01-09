package Alex_Scotson.forum.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name = "topics")
public class Topic {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String title;

    @NotEmpty
    private String message;

    public Topic() {

    }

    public Topic (String username, String title, String message) {
        this.username = username;
        this.title = title;
        this.message = message;
    }

    public Topic (Integer id, String username, String title, String message) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.message = message;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getUser () {
        return username;
    }

    public void setUser (String username) {
        this.username = username;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    

}
