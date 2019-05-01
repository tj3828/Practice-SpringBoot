package me.tj3828.user;

import org.springframework.stereotype.Service;

/**
 * @author tj3828
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    // 생성자를 통한 객체 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
