package me.tj3828;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tj3828
 */

/**
 * Spring Boot Security
 *
 * 1. Spring Boot에서 제공하는 @EventListener annotation을 이용하여
 *    AuthenticationFailureBadCredentialsEvent와 같은 여러가지 Event가 작동될 때 호출가능.
 *
 * 2. 기본적으로 모든 static content에 대해서 security 인증을 검사함.
 *      -> WebSecurityConfigurerAdapter의 메소드를 오버라이드하여 기본 설정을 변경할 수 있음.
 *
 *
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


