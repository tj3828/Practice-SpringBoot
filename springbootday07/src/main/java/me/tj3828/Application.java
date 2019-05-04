package me.tj3828;

import me.tj3828.user.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tj3828
 */

/**
 * 1. @Profile의 사용 - 해당 name에 대한 값이 존재할 때만 빈을 주입 (spring.profiles.active=)
 * 2. 우선순위에 따른 오버라이드 ( Command Line > application.properties )
 * 3. logging style
 * 4. Logging File Output - default 10MB 이상시  rotate, default = 10개 이상시 rotate
 *          - 경로 설정시 우선순위 : file > path
 * 5. Custom Logging - logback-spring.xml 등으로 설정 가능
 * 6. logback, log4j2, JUL을 지원하는데 JUL은 classlaading 이슈가 존재하여 비추.
 * 7. springProfile을 이용하여 값에 따른 로깅 속성 변경 가능.
 * 8. springProperty을 이용하여 Environment의 속성을 사용할 수 있음.
 */

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    MyBean myBean;

    @RequestMapping("/")
    public String hello() {
        System.out.println(myBean.getMessage());

        return "Hello";
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
     // springApplication.setAdditionalProfiles(" ", " ");
        springApplication.run(args);
    }

}
