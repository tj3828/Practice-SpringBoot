package me.tj3828.springbootday18;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tj3828
 */

@RunWith(SpringRunner.class)
@DataMongoTest
public class MeetingRepositoryTests {

    @Autowired
    MeetingRepository meetingRepository;

    @Test
    public void findByAddress() {
        // Given
        Meeting meeting = new Meeting();
        meeting.setTitle("new meeting");
        meeting.setAddress("Seoul");
        meetingRepository.save(meeting);

        Meeting mongoMeeting = new Meeting();
        mongoMeeting.setTitle("Mongo Study");
        mongoMeeting.setAddress("Seoul");
        meetingRepository.save(mongoMeeting);

        // When
        List<Meeting> address = meetingRepository.findByAddress("Seoul");

        // Then
        assertThat(address.size()).isEqualTo(2);
        assertThat(address).contains(mongoMeeting);
    }

}

