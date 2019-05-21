package me.tj3828.springbootday20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 *  RestTemplate RestService
 *
 *  - Rest 서비스를 필요할 때 사용.
 *
 *  - 스프링 부트는 RestTemplate을 제공해주지 않고 RestTemplateBuilder를 통해 생성해야함.
 *      -> RestTemplateBuilder가 sensible한 HttpMessageConverters을 auto-configuration함.
 *
 *  - Customization 3가지
 *      1) 가장 작은 범위 (메소드 호출마다 새로운 RestTemplateBuilder 인스턴스 생성) : RestTemplateBuilder.build()
 *      2) application-wide range : RestTemplateCustomizer을 구현하여 등록
 *      3) RestTemplateBuilder 빈을 만들어서 사용. -> 기존 RestTemplateBuilder auto-configuration 모두 off
 *
 *  - 단점 : 직관적이고 이해하기 쉬운 코드이나, 디펜던시 관계인 작업이 아닌 경우 bloking으로 인해 효율 저하 -> webFlux(WebClient)
 *
 */

@SpringBootApplication
public class Springbootday20Application {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public static void main(String[] args) {
        SpringApplication.run(Springbootday20Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            RestTemplate build = restTemplateBuilder.build();

            // Github Repository 호출
            GithubRepository[] resultRepos = build.getForObject("https://api.github.com/users/tj3828/repos", GithubRepository[].class);
            Arrays.stream(resultRepos).forEach(r -> {
                System.out.println("Repository : " + r.getUrl());
            });

            // Github Commit 호출
            GithubCommit[] resultCommit = build.getForObject("https://api.github.com/repos/tj3828/Practice-SpringBoot/commits", GithubCommit[].class);
            Arrays.stream(resultCommit).forEach(r -> {
                System.out.println("Commit : " + r.getSha());
            });

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());

        };
    }

}
