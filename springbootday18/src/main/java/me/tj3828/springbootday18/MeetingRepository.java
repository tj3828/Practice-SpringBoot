package me.tj3828.springbootday18;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author tj3828
 */
public interface MeetingRepository extends PagingAndSortingRepository<Meeting, String> {

    List<Meeting> findByAddress(String location);

}
