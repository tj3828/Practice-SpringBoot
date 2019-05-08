package me.tj3828;

/**
 * @author tj3828
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 1. WebFlux - Spring Framework 5.0에 추가된 기능.
 *            - Servlet API를 요구하지 않고, 완전한 asynchronous와 non-blocking.
 *            - Functional(Handler와 Mapping이 분리) 과 Annotation(Spring MVC와 매우 유사) 형태로 구현 가능.
 *            - 기본으로 Embedded Netty Server을 사용.
 *            - Mono(0~1개)나 Flux(0~N개) 등 reactor 타입을 사용할 수 있음.
 *            - @EnableWebFlux는 Spring boot에서 제공하는 webFlux auto config를 사용하고 싶지 않을 때 사용.
 *
 * 2. @JsonComponent - MVC와 마찬가지로 @JsonComponent Annotation으로 serializer과 deserializer 가능.
 * 3. Static Content - MVC와 동일 (WebFluxConfigurer 이용)
 * 4. Template Engine - Thymeleaf를 제외한 Template은 대용량 데이터 전송시 block 현상으로 인해 (webFlux의 non-blocking이 의미 없어짐.) reactive 장점을 살릴 수 없음.
 *                    - Chunked : Thymeleaf는 데이터를 쪼개서 보낼 수 있음.(blocking 현상은 동일하지만 view가 랜더링할 때 데이터를 쪼개서 보냄)
 *                                  -> 반응성이 빠르긴 하지만 결과적으로 랜더링 시간은 비슷.
 *                    - DataDriven : Flux를 Model에 담음.( 데이터를 메모리에 올리지 않고, 버퍼에 따른 non-blocking
 *             -> 결과적으로 최종적으로 랜더링 완료시간이 줄어드는 것은 아니지만 최초 응답시간이 빨라지는 효과보임.
 *             -> 클라이언트에서 요청시에 header에 stream정보를 넣어주면 서버에서 동작하는 방식이 달라짐.
 *                      (한번에 넘겨주는 것이 아니라 쪼개서 넘겨줌) -> 쪼개는 경우에 따라 성능이 달라짐.
 *     Example :  https://github.com/thymeleaf/thymeleafsandbox-biglist-reactive
 *
 *  5. ErrorHandling - Spring MVC와 비슷.
 *  6. Web Filter - WebFilter의 구현체를 구현하여 필터를 만들수 있음.
 *                - @Order로 필터의 실행 순서를 정할 수 있음.
 */
@SpringBootApplication
public class Application {

    @Autowired
    BookFunctionalHandler handler;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> router() {
        return route(GET("/book").and(accept(APPLICATION_JSON)), handler::allBooks);
    }

}
