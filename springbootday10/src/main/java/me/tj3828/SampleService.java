package me.tj3828;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author tj3828
 */

@Service
public class SampleService {

    RestTemplate restTemplate;

    public SampleService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getName() {
        return restTemplate.getForObject("/foo", String.class);
    }

}
