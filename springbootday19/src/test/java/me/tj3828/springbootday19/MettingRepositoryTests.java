package me.tj3828.springbootday19;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tj3828
 */

@RunWith(SpringRunner.class)
@DataNeo4jTest
public class MettingRepositoryTests {

    @Autowired
    MeetingRepository meetingRepository;

    @Test
    public void findByTitle() {
        Meeting meeting = new Meeting();
        meeting.setTitle("neo4j");
        meeting.setName("seoul");
        meetingRepository.save(meeting);


        List<Meeting> result = meetingRepository.findByTitleContains("neo4j");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result).contains(meeting);

    }

}
