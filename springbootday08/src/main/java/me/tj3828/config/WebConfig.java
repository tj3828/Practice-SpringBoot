package me.tj3828.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tj3828
 */

//@EnableWebMvc  => 기존 설정은 무시되고 자신이 필요한 것을 모두 설정해주어야함.
@Configuration
public class WebConfig implements WebMvcConfigurer, WebMvcRegistrations {

    @Bean
    public HttpMessageConverters customConverters() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        return new HttpMessageConverters(converter);
    }

}
