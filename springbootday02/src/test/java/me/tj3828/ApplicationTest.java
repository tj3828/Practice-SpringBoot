package me.tj3828;

import me.tj3828.user.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tj3828
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    UserService userService;

    @Test
    public void TestDI() {
        Assert.assertNotNull(userService);
        Assert.assertNotNull(userService.getUserRepository());
    }
}
