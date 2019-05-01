package me.tj3828;

/**
 * @author tj3828
 */

/**
 * 1. devtools을 이용하면 코드상의 변화를 서버의 재구동 없이 Build만 한다면 재구동하는 것보다 빠른 속도로 restart가 됨.
 * 2. 기본적으로 /META-INF/maven, /META-INF/resources, /resources, /static, /public, /templates은 트리거하지 않음.
 * 3. classpath에 해당하지 않은 파일도 restart되도록 추가 경로 설정할 수 있음.
 * 4. spring.devtools.restart.enabled 속성을 통해 off시킬수 있음.
 * 5. 특정 파일에서만 restart만 일어나도록 할 수 있음. (spring.devtools.restart.trigger-file)
 * 6. livereload 플러그인으로 소스 변경에 따른 브라우저 refresh 자동 기능.
 */

import me.tj3828.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    public String hello() {
        return helloService.getMessage();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
