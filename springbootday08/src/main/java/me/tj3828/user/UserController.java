package me.tj3828.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author tj3828
 */

@RestController
public class UserController {

    @Autowired
    HttpMessageConverters converters;

    /*@RequestMapping("/")
    public String hello() {
        converters.getConverters().forEach(c -> System.out.println(":::::::::::::::::::: " + c.getClass()));
        return "main";
    }*/

    @GetMapping("/user")
    public User currentUser() {
        User user = new User();
        user.setAge(20);
        user.setName("tak");
        user.setHeight(177);
        return user;
    }

}
