package me.tj3828.springbootday16;

import me.tj3828.jooq.Sequences;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.Optional;

import static me.tj3828.jooq.tables.Meeting.MEETING;

/**
 * @author tj3828
 */

@Component
public class DefaultDataPopulator implements ApplicationRunner {

    @Autowired
    DSLContext dslContext;

    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Person person = new Person();
        person.setEmail("tj3828@naver.com");
        person.setName("tj3828");
        person.setJoined(new Date());

        personRepository.save(person);

        Optional<Person> byEmail = personRepository.findByEmail("tj3828@naver.com");
        System.out.println(byEmail.get().getName());


        Meeting meeting = new Meeting();
        meeting.setTitle("new meeting");
        meeting.setLocation("seoul");
        meetingRepository.save(meeting);

        //jOOQ
        dslContext.insertInto(MEETING)
                .set(MEETING.ID, Sequences.HIBERNATE_SEQUENCE.nextval())
                .set(MEETING.TITLE, "jOOQ Study")
                .set(MEETING.LOCATION, "Seoul")
                .execute();

    }
}
