package me.tj3828;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 1. @WebFilter를 이용해 빈 등록과 동시에 urlpattern 등록가능 ( @ServletComponentScan 설정 필요)
 * 2. 내장 컨테이너 커스터마이징
 *      (밑으로 갈수록 우선순위 높아짐 = 오버라이딩됨)
 *      1) application.properties or application.yml에 의한 설정
 *      2) WebServerFactoryCustomizer의 구현체에서 커스터마이징
 *      3) TomcatServletWebServerFactory를 직접 구현하여 빈으로 등록.
 *
 * 3. JSP Limit - war패키징만 가능하고, jar패키징이 안됨.(Tomcat and Jetty)
 *                  -> Thymeleaf 사용이 좋을듯....
 */


@SpringBootApplication
@ServletComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
