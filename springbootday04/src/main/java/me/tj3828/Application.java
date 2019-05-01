package me.tj3828;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tj3828
 */

/**
 * 1. SpringApplication - 기본적으로 info 레벨 이상의 로그를 출력
 *                      - application.properties의 속성을 통해 로그 레벨 설정 가능
 * 2. FailureAnalyzer - 실패분석기를 통해 특정 오류에 대한 해결책을 콘솔창에 출력해줌.
 * 3. 배너 설정 - 콘솔창에 출력되는 배너를 커스터마이징 할 수 있음.
 * 4. ApplicationContext가 만들어지기 전 후에 과정에서 특정 시점의 이벤트를 호출할 수 있음.
 */
@RestController
@SpringBootApplication
public class Application {

    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBanner(new MyBanner());
        //springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.addListeners(new MyListener());
        springApplication.run(args);

        //SpringApplication.run(Application.class, args);
    }
}
