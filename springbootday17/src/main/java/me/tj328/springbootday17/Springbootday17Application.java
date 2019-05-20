package me.tj328.springbootday17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * NOSQL - Redis
 *
 * 1. 스프링 부트는 Lettuce와 Jedis client libraries를 위해 auto configuration 제공.
 * 2. 기본적으로 Lettuce를 사용.
 * 3. localhost:6739 Redis Server와의 연결이 기본 설정.
 * 4. LettuceClientConfigurationBuilderCustomizer를 구현함으로써 Customer 가능.
 *      -> jedis는 JedisClientConfigurationBuilderCustomizer
 * 5. spring-boot-starter-data-redis 디펜던시를 통해 자동 빈 등록 객체
 *      -> RedisConnectionFactory, StringRedisTemplate, or vanilla RedisTemplate
 *
 */

@SpringBootApplication
public class Springbootday17Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootday17Application.class, args);
    }

}
