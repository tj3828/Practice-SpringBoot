package me.tj3828.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author tj3828
 */

@Service
public class UserService {

    @Value("${tj3828.name}")
    String name;

    @Autowired
    TakProperties takProperties;

    public String getName() {
        return takProperties.getName() + " " + takProperties.getList().size();
    }
}
