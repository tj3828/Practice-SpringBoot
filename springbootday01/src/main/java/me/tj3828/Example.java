package me.tj3828;

import me.tj3828.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController             // Spring annotation
@SpringBootApplication    // Spring boot annotation
public class Example {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}
