package me.tj3828;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tj3828
 */

@RestController
public class SampleController {

    @Autowired
    SampleService service;

    @GetMapping("/foo")
    public String foo() {
        return service.getName();
    }

}
