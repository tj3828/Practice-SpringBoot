package me.tj3828;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author tj3828
 */

@RunWith(SpringRunner.class)
@JsonTest
public class SampleJsonTest {


    JacksonTester<Sample> jacksonTester;

    // 웹이 아닌 환경에서 json을 test하고 싶다면..
    /*@Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }*/


    @Test
    public void testJson() throws Exception {
        Sample sample = new Sample();
        sample.setName("tak");
        sample.setNumber(100);

        JsonContent<Sample> jsonContent = jacksonTester.write(sample);
        assertThat(jsonContent)
                .hasJsonPathStringValue("@.name")
                .extractingJsonPathStringValue("@.name").isEqualTo("tak");

        assertThat(jsonContent)
                .hasJsonPathNumberValue("@.number")
                .extractingJsonPathNumberValue("@.number").isEqualTo(100);
    }

}
