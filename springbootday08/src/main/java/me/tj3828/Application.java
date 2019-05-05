package me.tj3828;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tj3828
 */

/**
 * 1. Spring MVC - ContentNegotiatingViewResolver (요청으로 들어온 view의 타입으로 반환될 view를 내부 로직으로 판단)
 *               - BeanNameViewResolver (반환된 이름으로 된 빈을 찾아서 뷰를 빈이 제공하는 컨텐츠로 제공)
 *     ex) return "name" -> ViewResolver -> View(여러개) -> ContentNegotiatingViewResolver(최종 판단) -> View
 *
 *               - HttpMessageConverters (반환되는 타입이 객체를 경우 json, byte stream 등 어떤 것으로 바꿀 것인지 결정
 *                 -> Bean 추가를 통해 MessageConverters에 추가 가능.
 *
 * 2. additional config - WebMvcRegistrations (HandlerMapping, HandlerAdapter, ExceptionHandler)
 *                      - WebMvcConfigurer (기타 기능)
 *
 * 3. @JsonComponent - JSON Data serializer or deserializer
 * 4. @Valid의 사용 - @Valid의 설정에 따라 맞지 않은 변수는 BindingResult를 통해 반환
 * 5. static Content - 기본적으로 /static, /public, /resources, /META-INF/resources 경로의 content를 읽음.
 *                   - 루트 경로와 위치를 properties를 통해 변경 가능.
 *                   - favicon.ico 명을 자동적으로 오바리이드 하여 설정.
 * 6. webjar를 통한 프론트엔드 라이브러리 추가 - webjar의 해당 라이브러리를 maven을 추가하고 사용.
 *                                         - version agnostic URLs (webjars-locator-core dependency를 사용하여 버전 입력 필요없이 경로 설정가능.)
 * 7. cache_busting - css와 같은 파일의 내용이 변경됬을 때 캐시에 의해 변경값이 반영이 안될 수 있음.
 *                      -> 파일명 뒤에 캐시값을 붙여주어 바로바로 반영해주는 것.
 * 8. 기본적으로 index.html을 찾아서 실행하도록 설정되어 있음. ("/" 루트로 매핑되어 있지 않을 때)
 * 9. 스프링 부트는 suffix pattern 맵핑을 하지 않음. (원한다면 properties의 파라미터 값을 설정을 통해 가능 or favor-path-extension 속성으로 활성화 가능)
*           -> 우선순위 : 기본 < Accept header < format parameter < favor-path-extension
 *
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
