package me.tj3828.springbootday20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 *  WebClient WebFlux
 *
 *  - WebFlux 기반의 Rest 서비스를 필요할 때 사용.
 *
 *  - RestTemplate에 비해 Functional, reactive(non-blocking)
 *  - 자동으로 빈으로 등록된 WebClient.Builder를 통해 WebClient를 빌드.
 *
 *  - Customization 3가지
 *      1) 가장 작은 범위 (메소드 호출마다 새로운 WebClient.Builder 인스턴스 생성) : WebClient.Builder.build()
 *          -> 같은 빌더를 특정 메소드에서 커스터마이징을 통한 빌더를 사용하기 원한다면 WebClient.Builder other = builder.clone();
 *      2) application-wide range : WebClientCustomizer를 구현하여 등록
 *      3) WebClient.create()를 사용하여 original API로 만들어지고 auto-configuration은 off
 *
 *  - non-blocking으로 console창에 출력이 다르게 찍힘.
 *      -> 비동기적으로 처리됨.
 *
 *  - FLux의 doOnNext()를 사용할 경우 데이터 하나를 얻을 때마다 호출되어 순서가 뒤죽박죽으로 찍힘.
 *  - subscribe() = doOnNext() + subscribe()
 *
 */
@SpringBootApplication
public class Springbootday20Application {

    @Autowired
    WebClient.Builder builder;

    public static void main(String[] args) {
        SpringApplication.run(Springbootday20Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            WebClient webClient = builder.baseUrl("https://api.github.com").build();

            Flux<GithubRepository> monoRepos = webClient.get().uri("/users/tj3828/repos")
                    .retrieve()
                    .bodyToFlux(GithubRepository.class);

            Flux<GithubCommit> monoCommit = webClient.get().uri("/repos/tj3828/Practice-SpringBoot/commits")
                    .retrieve()
                    .bodyToFlux(GithubCommit.class);

//            monoRepos.doOnSuccess(githubRepositories -> {
//                Arrays.stream(githubRepositories).forEach(r -> {
//                    System.out.println("Repository : " + r.getUrl() );
//                });
//            }).subscribe();
//
//            monoCommit.doOnSuccess(githubCommits -> {
//                Arrays.stream(githubCommits).forEach(r -> {
//                    System.out.println("Commit : " + r.getSha());
//                });
//            }).subscribe();

            monoRepos.subscribe(r -> System.out.println("Repository : " + r.getUrl()));

            monoCommit.subscribe(r -> System.out.println("Commit : " + r.getSha()));

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        };
    }

}
