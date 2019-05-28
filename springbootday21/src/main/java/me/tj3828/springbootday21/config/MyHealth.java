package me.tj3828.springbootday21.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author tj3828
 */

@Component
public class MyHealth implements HealthIndicator {

    @Autowired
    MyEndpoint myEndpoint;

    @Override
    public Health health() {
        if(myEndpoint.getValue().equals("down")) {
            return Health.down()
                    .withDetail("reason", "I don't know why the broadcasting is blocked suddenly. ")
                    .build();
        }

        return Health.up().build();
    }
}
