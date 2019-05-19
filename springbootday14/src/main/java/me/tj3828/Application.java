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
 * Embedded DB
 *
 * 1. H2, HSQL 등 존재
 * 2. HSQL을 사용하여 Embedded DB를 만들고 DDL과 DML을 사용하여 스키마와 데이터를 넣고, JdbcTemplate으로 select
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
