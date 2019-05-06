package me.tj3828;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author tj3828
 */
public class BroadCastReource extends ResourceSupport {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
