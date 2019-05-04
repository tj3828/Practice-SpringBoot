package me.tj3828.user;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author tj3828
 */

@Component
@Profile("dev")
public class DevBean implements MyBean {
    @Override
    public String getMessage() {
        return "Dev Bean";
    }
}
