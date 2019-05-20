package me.tj3828.springbootday18;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * @author tj3828
 */

@Document(collection = "meetings")
public class Meeting {

    @Id
    private String id;

    private String title;

    private String address;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id) &&
                Objects.equals(title, meeting.title) &&
                Objects.equals(address, meeting.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, address);
    }
}
