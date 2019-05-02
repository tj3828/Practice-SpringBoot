package me.tj3828;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tj3828
 */

/**
 * 1. SpringApplication Runner Order
 * 2. jconsole을 통한 Admin(MBeanServer)이용
 *    - 메모리영역, 쓰레드, 클래스 갯수 등 Application이 돌아갈 때의 여러가지 정보를 볼 수 있음.
 * 3. 외부 설정의 우선 순위
 *    - java -jar target\springbootday05-1.0-SNAPSHOT.jar --name=good (Command Line) > application.properties의 name 값 (Application Properties)
 *    - applicatiom.properties의 name 값 < java -jar -Dname=springboota trget\springbootday05-1.0-SNAPSHOT.jar (System Properties)
 * 4. Random Values - random 속성을 이용해 int, uuid 등과 같은 랜덤값 출력 가능
 * 5. application.properties의 파일 위치는 현재 디렉토리의 config/application.properties를 먼저 읽고 그 다음 classpath root의 properties를 확인
 * 6. properties에서 ${}를 사용해 이전의 값을 사용할 수 있음.
 *
 */

@SpringBootApplication
@RestController
public class Application {

    @Value("${name}")
    String nameValue;

    @RequestMapping("/")
    public String hello() {
        return nameValue;
    }

    public static void main(String[] args) {
        SpringApplication springBootApplication = new SpringApplication(Application.class);
        springBootApplication.addListeners(new MyListener());
        springBootApplication.run(args);
    }

}
