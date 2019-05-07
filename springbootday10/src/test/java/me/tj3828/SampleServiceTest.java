package me.tj3828;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author tj3828
 */

@RunWith(SpringRunner.class)
@RestClientTest(SampleService.class)
public class SampleServiceTest {

    @Autowired
    SampleService sampleService;

    @Autowired
    MockRestServiceServer server;

    @Test
    public void fooTest() {
        server.expect(requestTo("/foo"))
                .andRespond(withSuccess("tj3828", MediaType.TEXT_PLAIN));

        String name = sampleService.getName();
        assertThat(name).isEqualTo("tj3828");
    }

}
