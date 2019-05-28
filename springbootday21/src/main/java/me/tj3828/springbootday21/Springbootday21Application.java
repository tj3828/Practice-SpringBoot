package me.tj3828.springbootday21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Actuator
 *
 *  - Http Endpoints나 JMX로 Application의 상태를 모니터링할 수 있는 도구.
 *  - spring-boot-starter-actuator 디펜던시를 통해 자동 설정 가능.
 *
 *  - Endpoint
 *      -> 자동 설정으로 제공해주는  Endpoint가 여러가지 있음. (Web은 보안상 대부분 비활성화 되어 있음. JMX는 대부분 활성화)
 *      -> Application Context에 빈이 존재하는 Endpoint에 대해 접근 가능.
 *      -> management.endpoints.web.exposure.include를 통해 endpoint를 활성화 할 수 있음.
 *      ex ) http://localhost:8080/actuator/health
 *      -> management.endpoints.web.base-path를 통해 actuator가 아닌 customizing을 통해 사용가능
 *      -> management.server.port를 통해 actuator를 별도의 포트에 띄울 수 있음. (port = -1 : HTTP 비활성화, JMX에서만 접근가능)ㅓ
 *
 *      -> management.endpoint.<name>.cache.time-to-live=10s를 통해 캐싱설정 가능.
 *      -> management.endpoints.web.cors.allowed-origins을 통해 CORS 지원
 *
 *  - Custom Endpoint
 *      -> @ReadOperation(GET), @WriteOperation(POST), or @DeleteOperation(DELETE) 을 통해 설정가능
 *      -> 요청 파라미터는 Web : URL의 쿼리 파라미터나 JSON request body.
 *                       JMX : MBeans의 operations의 파라미터
 *
*   - Health Detail Information : management.endpoint.health.show-details Properties를 통해 detail 정보 설정 가능.
 *  - Custom HealthIndicators : HealthIndicator의 구현체를 빈으로 등록하여 사용.
 *
 *  - Application Information : info.app.{ } properties를 이용하여 정보를 노출시킬 수 있고, @ 패턴으로 메이븐의 정보를 사용할 수 있음.
 *      -> Custom info : InfoContributor의 구현체를 빈으로 등록하여 사용.
 *
 *  - Actuator Logger : Runtime 중에 logger설정을 바꿀 수 있음.
 *      -> http://localhost:8080/actuator/loggers/org.springframework.web 와 같이 특정 로그의 상태를 볼 수 있음.
 *      -> http://localhost:8080/actuator/loggers/org.springframework.web의 경우 POST 메소드로 configuredLeve, debug 형태로 body에 넣어주면됨.
 *
 */

@SpringBootApplication
public class Springbootday21Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootday21Application.class, args);
    }

}
