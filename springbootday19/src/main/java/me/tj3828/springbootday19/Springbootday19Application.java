package me.tj3828.springbootday19;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *  NoSQL (Neo4j)
 *
 *  - NoSQl graph db ( 연결되어 있는 빅데이터를 다루는데 용이)
 *  - spring-boot-starter-data-neo4j 의존성을 통해 org.neo4j.ogm.session.Session이 빈으로 자동 주입
 *  - default Neo4j Server : localhost:7474
 *  - org.neo4j.ogm.config.Configuration 빈 등록을 통해 커스터마이징 가능.
 *  - SessionFactory을 통해 모든 자동 설정을 끌 수 있음.
 *
 *  - Repository : Sptring Data JPA와 같은 infrastructure을 가짐.(Neo4jRepository)
 *  - @Entity 대신 @NodeEntity 사용
 *
 *  - org.neo4j:neo4j-ogm-embedded-driver, neo4j 디펜던시를 통한 Embedded Mode 지원
 *      -> 파일을 통해 spring.data.neo4j.uri=file://var/tmp/graph.db와 같은 경로로 영속화 시킬 수 있음.
 *
 *
 */

@SpringBootApplication
public class Springbootday19Application {

    @Autowired
    MeetingRepository meetingRepository;

    public static void main(String[] args) {
        SpringApplication.run(Springbootday19Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {

            Meeting meeting = new Meeting();
            meeting.setName("New Meeting");
            meeting.setTitle("Neo4J Study");
            meetingRepository.save(meeting);

        };
    }

}
