package me.tj3828.springbootday21.config;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * @author tj3828
 */

@Component
@Endpoint(id = "my")
public class MyEndpoint {

    private String value="hello world";

    @ReadOperation
    public String getValue() {
        return this.value;
    }

    @WriteOperation
    public void setValue(String value) {
        this.value = value;
    }

    @DeleteOperation
    private void deleteValue() {
        this.value ="hello world";
    }

}
