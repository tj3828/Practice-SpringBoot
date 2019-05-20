package me.tj3828.springbootday16;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author tj3828
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

}
