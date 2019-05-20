package me.tj3828.springbootday18;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * NoSQL - MongoDB
 *
 * 1. JSON과 같은 schema를 사용하는 db
 * 2. spring-boot-starter-data-mongodb 디펜던시를 추가할 시 auto configuration 된 MongoDbFactory가 주입됨.
 * 3. 기본 설정으로는 mongodb://localhost/test에 연결, 기본 포트는 27017
 * 4. JdbcTemplate과 비슷한 MongoTemplate을 지원함. (insert시 기본 collection name을 설정안한다면 클래스 이름에서 추론하여 설정됨.)
 * 5. MongoDB Repository 지원 (JpaRepository와 매우 유사) -> @Document를 사용하여 collection 설정
 *
 * 6. Embedded Mongo - de.flapdoodle.embed:de.flapdoodle.embed.mongo 디펜던시
 *          -> port를 설정하여 사용가능 (0이면 랜덤포트, default는 27017을 제외한 랜덤)
 *          -> 주로 test용
 *
 * 7. reactive Mongo의 경우 ReactiveMongoRepository를 사용하여 Flux나 Mono를 리턴할 수 있음.
 *          -> Repository의 save와 같은 경우에도 비동기적으로 일어나기 때문에 원하는 테스트 값이 나오지 않음.
 *              -> 각 Repository의 변경호출 때마다 blocking 해주어야함.
 */

@SpringBootApplication
public class Springbootday18Application {

    @Autowired
    MongoDbFactory mongoDbFactory;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MeetingRepository meetingRepository;

    public static void main(String[] args) {
        SpringApplication.run(Springbootday18Application.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
//            MongoDatabase db = mongoDbFactory.getDb();
//            db.createCollection("meetings");

//            db.getCollection("meetings").insertOne(
//                    new Document()
//                        .append("title", "new Meeting")
//                        .append("location", "seoul")
//            );

//            Meeting meeting = new Meeting();
//            meeting.setAddress("Seoul");
//            meeting.setTitle("MongoStudy");
//            mongoTemplate.insert(meeting, "meetings");

            meetingRepository.findByAddress("Seoul").forEach(m->{
                System.out.println("========");
                System.out.println(m);
            });

        };
    }
}
