package me.tj3828;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author tj3828
 */

/**
 * Production DB
 *
 * 1. Inmemory DB : h2, hsql, derby .. ,
 *
 * 2. h2 console 사용 : http://localhost:8080/h2-console
 *      -> 최소 spring.datasource.url을 설정해야 Production DB로 사용됨.
 *      -> file을 사용하여 persistent를 유지할 수 있음.
 *      -> spring.datasource.driver-class-name은 Spring boot에서 알아서 추론함.
 *
 * 3. spring-boot-starter-jdbc를 의존성 추가했다면, JdbcTemplate과 NamedParameterJdbcTemplate은 자동으로 빈에 등록됨.
 *
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(JdbcTemplate jdbcTemplate) {
        return args -> {
            Integer count = jdbcTemplate.queryForObject("select count(*) from Customers", Integer.class);
            System.out.println("count : " + count);
        };
    }
}
