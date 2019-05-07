package me.tj3828;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author tj3828
 */

@TestConfiguration
public class TestConfig {

    @Bean
    public String myBean() {
        return "MyBean";
    }
}
