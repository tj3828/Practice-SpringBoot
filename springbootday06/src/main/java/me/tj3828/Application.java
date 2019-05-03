package me.tj3828;

import me.tj3828.user.TakProperties;
import me.tj3828.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tj3828
 */

/**
 * 1. YAML 파일 사용
 * 2. @ConfigurationProperties("tj3828")을 이용해 tj3828에 관련된 값 저장하여 @Component로 빈에 등록
 * 3. 해당 클래스에 접근이 어려운 경우 객체 생성과정에서 바인딩과 빈 등록도 가능
 * 4. 바인딩 될 때 -,_ 등에 대해 유연하게 바인딩 가능.
 * 5. Duration 타입으로 바인딩 가능
 * 6. Validation 기능 - 바인딩할 때 설정
 *
 *                    - @ConfigurationProperties vs @Value
 *  Relaxed binding                 Y                   N
 *  Metadata support                Y                   N
 *  SpEL evaluation                 N                   Y
 *
 */

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    UserService userService;

    @Autowired
    Environment environment;

    @Bean
    @ConfigurationProperties("tj3828")
    @Validated
    public TakProperties takProperties() {
        return new TakProperties();
    }

    @RequestMapping("/")
    public String hello() {
        System.out.println(environment.getProperty("tj3828.list[0].descr"));
        System.out.println(environment.getProperty("tj3828.name")); // tak default

        System.out.println(takProperties().getFooBar());
        System.out.println(takProperties().getWhereToGO());
        System.out.println(takProperties().getWorkFor());
        System.out.println(takProperties().getTime1());
        System.out.println(takProperties().getTime2());
        System.out.println(takProperties().getTime3());

        return userService.getName();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
