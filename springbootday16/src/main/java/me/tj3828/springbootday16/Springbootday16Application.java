package me.tj3828.springbootday16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Data JPA
 *
 *  1. JPA (Java Persistence API) : 객체를 relational db로 매핑할 수 있도록 해줌.
 *      -> spring-boot-starter-data-jpa dependency사용
 *
 *  2. @Entity을 사용하는 클래스를 찾아 Entity로 등록
 *      -> @GeneratedValue : 자동으로 값 생성. (sequence 등 설정에 따라 자동)
 *      -> @Column : Entity의 필드는 기본적으로 모두 Column으로 등록되는데 이 떄 설정값 변경가능(Nullable)
 *      -> @Temporal : Date의 형태에 따라 매핑하도록 설정.
 *
 *  3. Production DB (Postgresql) : docker을 이용하여 서버를 띄운후 접근.
 *      -> Application 실행시 @Entity의 해당 테이블 자동 생성.
 *
 *  4. JpaRepository : 인터페이스를 정의하면 이 인터페이스를 통해 RDBMS, NoSQL 등의 Repository와
 *                      데이터를 주고받을 수 있는 빈을 자동적으로 등록하는 기능
 *      -> JpaRepository를 상속받으면 자동으로 빈으로 등록됨.
 *      -> 메소드 명명규칙에 따라 sql문 없이 메소드로 호출가능.
 *                     -
 *  5. EntityManager : view에서 랜더링할 때 디비에 접근하여 데이터를 가져올 수 있게 하는 기능.
 *
 *  6. Java Object Oriented Querying (jOOQ) - SQl을 type-safe하게 작성 할 수 있도록 해줌.
 *      -> jOOQ plugin을 등록하고 compile하면 설정한 위치에 Entity를 스캔하고 각 Entity에 대한 쿼리를 만들 수 있는 클래스를 만들어줌.
 *      -> DSLContext가 자동으로 빈으로 등록됨.
 */

@SpringBootApplication
public class Springbootday16Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootday16Application.class, args);
    }

}
