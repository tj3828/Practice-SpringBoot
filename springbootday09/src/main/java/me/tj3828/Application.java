package me.tj3828;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;

/**
 * 1. Web Data Binding - HandlerAdapter가 가지고 있는 WebBindingInitializer을 통해 바인딩됨.
 * 			-> 방법
 * 			  1) Converter을 만들어 ConfigurableWebBindingInitializer 빈을 통해 설정.
 * 			  2) WebMvcConfigurer을 이용한 add Converter.
 * 			  3) Converter 자체를 빈으로 등록후 자동으로 사용. (제일 간단)
 *
 * 2. Dynamic HTML content (Template Engine) - Freemarker, groovy, thymeleaf 등
 *                                           - jsp는 embedded servlet contatiner에서 제약사항이 발생하기 때문에 비권장 (wor packaging만 사용가능)
 *              -> spring project generator을 통해 프로젝트 생성
 *
 * 3. Error Handling - machine client -> JSON 형태, browser client -> HTML WhiteLabel 형태
 * 					 - @ControllerAdvice와 @ExceptionHandler를 사용하여 Exception에 따른 커스터마이징 가능.
 *                   - 해당 Exception 설정에 없는 에러는 ErrorController가 받아 Custom Error Page로 넘어감.
 *
 * 4. Custom Error Page - /error 디렉토리 밑에 에러 코드에 따른 파일명으로 자동 호출.
 * 						- 5xx와 같은 series mask name으로도 가능.
 * 5. HATEOAS ( Hypermedia as the Engine of Application State) - 표현된 데이터에는 해당 자원의 상태에 따라 접근 가능한 추가 API들이 links 라는 이름으로 제공됨.
 * 															   - Spring boot는 auto config 되어 있음.
 * 															   - 연관된 url이 server side에서 바뀌더라도 client side에서 하드코딩하지 않고 변경된 사항을 바로 적용시킬 수 있음.
 *
 * 6. CORS ( Cross-Origin Resource Sharing ) - 특정 도메인에서만 접근 가능한 요청을 다른 도메인에서도 접근가능하도록 하는 기술
 * 													ex) http://localhost:8081/ ==
 * 											 - ACAO header에 허용 도메인을 입력함.
 * 											 - 스프링 부트에서는 @CrossOrigin 에노테이션으로 별도의 설정없이 사용가능.
 * 											 - WebMVCConfigurer을 통해서 Global CORS (모든 Controller에 CORS 설정) 설정가능
 */


@SpringBootApplication
public class Application {

	/*@Bean
	public ConfigurableWebBindingInitializer initializer() {
		ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
		ConfigurableConversionService conversionService = new FormattingConversionService();
		conversionService.addConverter(new BroadCastConverter());
		initializer.setConversionService(conversionService);
		return initializer;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
