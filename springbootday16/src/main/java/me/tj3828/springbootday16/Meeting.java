package me.tj3828.springbootday16;

import javax.persistence.*;

/**
 * @author tj3828
 */
@Entity
public class Meeting {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
