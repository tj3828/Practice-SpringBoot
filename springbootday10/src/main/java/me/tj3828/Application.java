package me.tj3828;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tj3828
 */

/**
 *  1. Spring Boot Test - @SpringBootTest 기준으로 해당 페키지에서 @SpringBootApplication 나 @SpringBootConfiguration를 찾는다.
 *                      - @TestConfiguration (main Config에 add)
 *                      - @SpringBootTest는 classpath 단에 따라서 알아서 테스트, @WebMvcTest or @WebFluxTest는 컨트롤러단 하나에서만 테스트.
 *                      - @AutoConfigureWebTestClient : webflux 기반 annotation. @AutoConfigureMockMvc : mvc 기반 annotation
 *                      - MockMVC : mvc, WebTestClient : webFlux
 *  2. MockMvc - ajax나 client(browser)에서 요청 내용을 Controller에서 받아 처리하는것과 같은 테스트를 진행
 *
 *  3. @MockBean, @SpyBean - 기존에 등록된 빈에 새로운 빈 형태를 넣어 실제 환경에서 테스트하기 어려운 형태를 만듬.
 *               - @MockBean default : empty, @SpyBean default : 기본 빈
 *
 *  4. @...Test, @Autoconfigure... - slice 테스트용으로 환경에 따라 test하기 위한 annotation
 *               - @...Test : ApplicationContext를 로드함.
 *               - @Autoconfigure... : auto configureation을 설정하는데 사용.
 *
 *               - @JsonTest : json serialization or deserialization을 확인하는데 사용. -> @JsonTest / JacksonTests
 *
 *  5. @WebMvcTest - default : @Controller, @ControllerAdvice, @JsonComponent, Converter, GenericConverter, Filter, WebMvcConfigurer, HandlerMethodArgumentResolver
 *                             만 스캔함.
 *  6. @DataJpaTest - in-memory memory embedded database
 *                  - @Entity 스캔, Spring Data JPA repositories 설정.
 *                  - ApplicationContext의 @Component 빈들을 로드하지 않음.
 *                  - TestEntityManager을 주입받을 수 있음.
 *
 *  7. @JdbcTest - 마찬가지.
 *
 *  8. Rest Client Test - @RestClientTest가 RestTemplateBuilder을 만들고,
 *                        RestTemplateBuilder은 RestTemplate에서 나가는 요청을 MockRestServiceServer에 보낸다.
 *
 *  9. Spring boot Rest docs - @AutoConfigureRestDocs을 이용하여 .andDo(document(" ")) 를 실행하면 target/generated-snippets 아래에 해당 doc 문서가 생성됨.
 *                           - @TestConfiguration을 이용하여 RestDocumentationResultHandler 빈을 생성하면 .andDo() 메소드를 쓰지 않아도 doc문서 생성.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
