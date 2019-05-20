package me.tj328.springbootday17;

import org.springframework.data.repository.CrudRepository;

/**
 * @author tj3828
 */


public interface MeetingRepository extends CrudRepository<Meeting, String> {
}
