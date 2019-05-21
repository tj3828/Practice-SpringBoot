package me.tj3828.springbootday19;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * @author tj3828
 */
public interface MeetingRepository extends Neo4jRepository<Meeting, Long> {

    List<Meeting> findByTitleContains(String title);

}
