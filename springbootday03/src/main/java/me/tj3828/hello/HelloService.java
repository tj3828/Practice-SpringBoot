package me.tj3828.hello;

import org.springframework.stereotype.Service;

/**
 * @author tj3828
 */

@Service
public class HelloService {

    public String getMessage() {
        return "Hello Spring Boot 2.0!";
    }
}
