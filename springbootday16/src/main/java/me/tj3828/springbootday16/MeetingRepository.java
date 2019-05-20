package me.tj3828.springbootday16;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tj3828
 */
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
