package me.tj3828.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tj3828
 */

@RestController
public class UserController {

    @GetMapping("/user")
    public User currentUser() {
        User user = new User();
        user.setAge(20);
        user.setName("tak");
        user.setHeight(177);
        return user;
    }

}
